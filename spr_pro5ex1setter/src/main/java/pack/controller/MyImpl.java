package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter{
	private SangpumInter sangpumInter;
	private String name;
	private int number;
	private int price;
	private int total;
		
	public void setSangpumInter(SangpumInter sangpumInter) {
		this.sangpumInter = sangpumInter;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
		
	@Override
	public void inputData() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("상품명: ");
			setName(scan.next());
			System.out.print("수량: ");
			setNumber(scan.nextInt());
			System.out.print("단가: ");
			setPrice(scan.nextInt());
			
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
