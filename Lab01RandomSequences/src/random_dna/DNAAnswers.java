package random_dna;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class DNAAnswers {
	static Random random = new Random();
	
	static String returnNucleotide(double aProb, double cProb,double gProb,double tProb) 
	{
		//Return mer (3 char nucleotide) using probabilities assigned by user
		String mer = "";
		
		for (int i=0;i<3;i++) {
	
			float f = random.nextFloat();
			String nucleotide = "";
			if (f < aProb) {
				nucleotide = "A";
			} else if (f < aProb+cProb) {
				nucleotide = "C";
			} else if (f < aProb+cProb+gProb) {
				nucleotide = "G";
			} else {
				nucleotide = "T";
			}
			mer = mer + nucleotide;
		}
		return mer;
	}
	
	static int runSimulation(double aProb, double cProb,double gProb,double tProb, int sim_count) 
	{
		// Count how many AAA mers are present in simulation with x random mers
		int aaaCount = 0;
		
		for (int i=0;i<sim_count;i++) {
			String sample = returnNucleotide(aProb,cProb,gProb,tProb);
			
			if (sample.equals("AAA")) {
				aaaCount++;
			}
		}
		return aaaCount;
	}
	
	public static void main(String[] args) 
	{

		// Question (1) and (2)
		int aaaCount1 = runSimulation(0.25,0.25,0.25,0.25,1000);
		
		// Question (3)
		int aaaCount2 = runSimulation(0.12,0.38,0.39,0.11,1000);
		System.out.println("#AAAs 25% each:");
		System.out.println(aaaCount1);
		System.out.println("EXPECTED AAA mers = 1000*0.25^3 = 15.625");
		System.out.println("#AAAs modified %s:");
		System.out.println(aaaCount2);
		System.out.println("EXPECTED AAA mers = 1000*0.12^3 = 1.728");
		
		double total_score = 0;
		double EXPECTED_VALUE = 10000*0.25*0.25*0.25;

/* 
// Extra cred - DELETE MULTILINE COMMENT FOR CHISQ PORTION OF ASSIGNMENT (lines 67 and 103)
		List<Double> chisqs = new ArrayList<Double>();
		
		for (int i=0; i<10;i++) {
			
			for (int j=0;j<10000;j++) {
				total_score = 0;
				int observed = runSimulation(0.12,0.38,0.39,0.11,10000);
				double new_chi = Math.pow(observed-EXPECTED_VALUE, 2)/EXPECTED_VALUE;
				total_score = total_score + new_chi;
				System.out.println(j);
			}
			chisqs.add(total_score);
			System.out.println(chisqs);
		}

		double sum = 0;
	    for (Double item : chisqs) {
	        sum += item;
	    }
	    double avg_chisq = sum / chisqs.size();
		System.out.println("FINAL AVERAGE of CHIsq VALUES: ");
		System.out.println(avg_chisq);
		
		// FROM R: chisq(0.05, 9999) = 9767.5
		double CRIT_VALUE = 9767.5;
		// IF Chi test value is > crit value, p < 0.01, so reject the null hypothesis 
		// that the actual distribution does not match the expected distribution
		
		
		if (avg_chisq > CRIT_VALUE) {
			System.out.println("Reject the null hypothesis that the actual distribution does not match the expected distribution");
		} else {
			System.out.println("Fail to reject the null hypotehsis that the actual distribution does not match the expected distribution");
		}
*/
	}

}
