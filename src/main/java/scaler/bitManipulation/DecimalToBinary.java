package scaler.bitManipulation;

public class DecimalToBinary {
    public static void main(String[] args) {
        StringBuilder reverseBinary = new StringBuilder();

        int temp = 11;

        while (temp > 1) {
            reverseBinary.append(temp % 2);
            temp = temp / 2;
        }

        reverseBinary.append(temp);

        System.out.println(reverseBinary.reverse());
    }
}
