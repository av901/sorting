package sorting;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] input = new int[] {3,6,5,1,8,19,2,11,21,23,14};
		mergeSort(input, 0, input.length-1);
		for(int i=0; i<input.length; i++) {
			System.out.print(input[i] + ", ");
		}
	}

	private static void mergeSort(int[] input, int lowIndex, int highIndex) {
		if(lowIndex < highIndex) {
			int mid = (highIndex + lowIndex)/2;
			mergeSort(input, lowIndex, mid);
			mergeSort(input, mid+1, highIndex);
			merge(input, lowIndex, mid, highIndex);
		}
		
	}

	private static void merge(int[] input, int lowIndex, int mid, int highIndex) {
		int p1 = lowIndex;
		int p2 = mid+1;
		int[] buff = new int[highIndex-lowIndex+1];
		int i = 0;
		while(p1<=mid&&p2<=highIndex) {
			if(input[p1] < input[p2]) {
				buff[i] = input[p1];
				p1++;
				i++;
			}else if(input[p1] == input[p2]){
				buff[i] = input[p1];
				p1++;
				i++;
				buff[i] = input[p2];
				p2++;
				i++;
			}else {
				buff[i] = input[p2];
				p2++;
				i++;
			}
		}
		if(p1>mid&&p2<=highIndex) {
			for(int j=p2;j<=highIndex;j++) {
				buff[i]=input[j];
				i++;
			}
		}
		if(p1<=mid&&p2>highIndex) {
			for(int j=p1;j<=mid;j++) {
				buff[i]=input[j];
				i++;
			}
		}
		p1=lowIndex;
		for(int j=0; j<i; j++) {
			input[p1]=buff[j];
			p1++;
		}
	}
}
