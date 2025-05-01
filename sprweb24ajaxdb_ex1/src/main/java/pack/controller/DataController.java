package pack.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.GogekDto;
import pack.model.JikwonDto;
import pack.model.BuserDto;

@Controller
public class DataController {
    @Autowired
    private DataDao dataProcess;
    
    @GetMapping("findgogek")
    @ResponseBody
    public Map<String, Object> gogekProcess(@RequestParam("gogekno") int gogekno,
                                            @RequestParam("gogekname") String gogekname) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        GogekDto gogekDto = dataProcess.findGogekDtoByNoAndName(gogekno, gogekname);
        
        if (gogekDto != null && gogekDto.getJikwon() != null) {
            JikwonDto jikwon = gogekDto.getJikwon();
            BuserDto buser = jikwon.getBuser();
            
            Map<String, String> data = new HashMap<>();
            data.put("jikwonname", jikwon.getJikwonname());
            data.put("jikwonjik", jikwon.getJikwonjik());
            data.put("busername", buser.getBusername());
            data.put("busertel", buser.getBusertel());
            
            resultMap.put("datas", data);
        } else {
            resultMap.put("error", "해당 고객 또는 담당 직원이 없습니다.");
        }
        
        return resultMap;
    }
}