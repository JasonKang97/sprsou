package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter{
	private SangpumInter sangpumInter;
	private String name;
	private int total;
	
	public MyImpl(SangpumInter sangpumInter) {
		this.sangpumInter = sangpumInter;
	}
	
	@Override
	public void inputData() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("상품명: ");
			name = scan.next();
			System.out.print("수량: ");
			int number = scan.nextInt();
			System.out.print("단가: ");
			int price = scan.nextInt();
			
			total = sangpumInter.calcMoney(number, price);
		} catch (Exception e) {
			System.out.println("inputData err: " + e);
		}
	}
	
	@Override
	public String showResult() {
		return "상품 " + name + ": 금액은 " + total + "원 입니다.";
	}
	
}
