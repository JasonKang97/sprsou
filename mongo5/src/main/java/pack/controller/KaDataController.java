package pack.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mongodb.client.MongoClient;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import pack.model.KaData;
import org.json.JSONArray;
import org.json.JSONObject;

@Controller
public class KaDataController {
	@Autowired
	private MongoClient mongoClient;
	
	@GetMapping("/")
	public String start() {
		return "index";
	}
	
	@GetMapping("/show")
	public String showData(Model model) {
		List<KaData> kaDataList = new ArrayList<KaData>();
		
		// MongoDB의 GridFsBucket에서 자료읽기
		GridFSBucket gridFSBucket = GridFSBuckets.create(mongoClient.getDatabase("katalkDB"), "katalkFiles");
		
		try {
			// GridFsBucket에서 저장된 자료를 하나씩 가져오기
			for(GridFSFile gridFSFile:gridFSBucket.find()) {
				ObjectId fileId = gridFSFile.getObjectId();
				
				// file download
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				gridFSBucket.downloadToStream(fileId, outputStream);
				String fileContent = new String(outputStream.toByteArray());
				
				// JSON 파싱
				if (fileContent.trim().startsWith("[")) {
					JSONArray jsonArray = new JSONArray(fileContent);
					for(int i=0;i<jsonArray.length();i++) {
						JSONObject jsonObject = jsonArray.getJSONObject(i);
						KaData kaData = new KaData();
						kaData.setReq(jsonObject.getString("req"));
						kaData.setRes(jsonObject.getString("res"));
						kaDataList.add(kaData);
					}
				} else {
					JSONObject jsonObject = new JSONObject(fileContent);
					KaData kaData = new KaData();
					kaData.setReq(jsonObject.getString("req"));
					kaData.setRes(jsonObject.getString("res"));
					kaDataList.add(kaData);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("err: " + e.getMessage());
		}
		
		model.addAttribute("dataList", kaDataList);
		
		return "show";
	}
	
}
