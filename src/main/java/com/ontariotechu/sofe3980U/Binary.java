package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}
	
		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		// uncomment the following code
		/*
		if (this.number.isEmpty()) { // replace empty strings with a single zero
			this.number = "0";
		}
  		*/
	}
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;

	}
	/**
	* Bitwise logical OR of two binary variables. The shorter number is padded
	* with leading zeros so both operands align on their least-significant bit.
	*
	* @param num1 The first operand object
	* @param num2 The second operand object
	* @return A binary variable with a value of <i>num1 OR num2</i>.
	*/
	public static Binary or(Binary num1,Binary num2)
	{
		int ind1=num1.number.length()-1; // least-significant digit of num1
		int ind2=num2.number.length()-1; // least-significant digit of num2
		String num3=""; // the binary value of the result
		while(ind1>=0 || ind2>=0) // process every digit of the longer number
		{
			int b1=(ind1>=0 && num1.number.charAt(ind1)=='1')? 1:0; // digit of num1 (0 when exhausted)
			int b2=(ind2>=0 && num2.number.charAt(ind2)=='1')? 1:0; // digit of num2 (0 when exhausted)
			int r=(b1==1 || b2==1)? 1:0; // OR: 1 if either bit is 1
			num3=((r==0)? "0":"1")+num3; // prepend the resultant digit
			ind1--; // step left in num1
			ind2--; // step left in num2
		}
		return new Binary(num3);
	}
	/**
	* Bitwise logical AND of two binary variables. The shorter number is padded
	* with leading zeros so both operands align on their least-significant bit.
	*
	* @param num1 The first operand object
	* @param num2 The second operand object
	* @return A binary variable with a value of <i>num1 AND num2</i>.
	*/
	public static Binary and(Binary num1,Binary num2)
	{
		int ind1=num1.number.length()-1; // least-significant digit of num1
		int ind2=num2.number.length()-1; // least-significant digit of num2
		String num3=""; // the binary value of the result
		while(ind1>=0 || ind2>=0) // process every digit of the longer number
		{
			int b1=(ind1>=0 && num1.number.charAt(ind1)=='1')? 1:0; // digit of num1 (0 when exhausted)
			int b2=(ind2>=0 && num2.number.charAt(ind2)=='1')? 1:0; // digit of num2 (0 when exhausted)
			int r=(b1==1 && b2==1)? 1:0; // AND: 1 only if both bits are 1
			num3=((r==0)? "0":"1")+num3; // prepend the resultant digit
			ind1--; // step left in num1
			ind2--; // step left in num2
		}
		return new Binary(num3);
	}
	/**
	* Multiply two binary variables using shift-and-add. For each '1' digit in
	* num2 (from least significant), num1 shifted left by that position is added
	* to the running total via {@link #add(Binary,Binary)}.
	*
	* @param num1 The first factor object
	* @param num2 The second factor object
	* @return A binary variable with a value of <i>num1 * num2</i>.
	*/
	public static Binary multiply(Binary num1,Binary num2)
	{
		Binary result=new Binary("0"); // running total, starts at zero
		String shifted=num1.number;    // num1 shifted left; appending '0' doubles it
		for(int i=num2.number.length()-1; i>=0; i--) // walk num2 from its last digit
		{
			if(num2.number.charAt(i)=='1'){ // this bit of num2 is set
				result=add(result,new Binary(shifted)); // add the current shifted num1
			}
			shifted=shifted+"0"; // shift left by one position (multiply by 2)
		}
		return result;
	}
}
