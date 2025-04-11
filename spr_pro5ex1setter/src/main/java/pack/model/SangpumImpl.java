package pack.model;

public class SangpumImpl implements SangpumInter{
	@Override
	public int calcMoney(int number, int price) {
		return number * price;
	}
}
