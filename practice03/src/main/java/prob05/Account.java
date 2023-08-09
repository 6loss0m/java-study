package prob05;

public class Account {

	private String accountNo;
	private int balance;

	public Account(String accountNo) {
		this.accountNo = accountNo;
		this.balance = 0;
		System.out.println(this.accountNo+" 계좌가 개설되었습니다.");
	}

	public void deposit(int i) {
		if ( this.balance - i < 0) {
			System.out.println("잔액이 부족합니다.");
		}else {
			this.balance = this.balance-i;
			System.out.println(this.accountNo+" 계좌에 "+i+"만원이 출금되었습니다.");
		}
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void save(int i) {
		this.balance = this.balance+i;
		System.out.println(this.accountNo+" 계좌에 "+i+"만원이 입금되었습니다.");
	}

	public int getBalance() {
		return this.balance;
	}
}
