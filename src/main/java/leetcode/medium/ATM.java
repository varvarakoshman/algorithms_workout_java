package leetcode.medium;

public class ATM {

    private static final int[] VALUES = new int[]{20, 50, 100, 200, 500};

    private final int[] banknotes;

    public ATM() {
        this.banknotes = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < this.banknotes.length; i++) {
            this.banknotes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] withdraw = new int[5];
        for (int i = this.banknotes.length - 1; i >= 0; i--) {
            withdraw[i] = Math.min(amount / VALUES[i], this.banknotes[i]);
            if (withdraw[i] > 0) {
                this.banknotes[i] -= withdraw[i];
                amount -= VALUES[i] * withdraw[i];
            }
        }
        if (amount != 0) {
            for (int i = 0; i < this.banknotes.length; i++) {
                this.banknotes[i] += withdraw[i];
            }
            withdraw = new int[]{-1};
        }
        return withdraw;
    }
}
