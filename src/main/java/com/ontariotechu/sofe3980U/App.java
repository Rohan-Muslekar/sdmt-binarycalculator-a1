package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;

/**
 * Entry point that exercises the Binary calculator.
 *
 */
public class App
{
	/**
	* Main program: prints the local time, builds two binary operands, and
	* reports the result of add, OR, AND, and multiply for those operands.
	*
	* @param args: not used
	*/
    public static void main( String[] args )
    {
		LocalTime startTime = new LocalTime();
		System.out.println("Binary calculator run at local time: " + startTime);
		Binary a = new Binary("110101");
		System.out.println("Operand A = " + a.getValue());
		Binary b = new Binary("10011");
		System.out.println("Operand B = " + b.getValue());
		System.out.println("A + B (add)      = " + Binary.add(a, b).getValue());
		System.out.println("A | B (bitwise OR)  = " + Binary.or(a, b).getValue());
		System.out.println("A & B (bitwise AND) = " + Binary.and(a, b).getValue());
		System.out.println("A * B (multiply)    = " + Binary.multiply(a, b).getValue());
    }
}
