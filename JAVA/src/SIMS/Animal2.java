package SIMS;
public class Animal2 {
	int length = 4;
	String name ="jj";
}
class test{
	public void showAnimal(Animal2 an) {
		System.out.println(an.name);
		System.out.println(an.length);		
	}
	public static int showAnimalh(int an) {
		System.out.println("e");
		System.out.println('a');
		return an;
	}
	public int ShowArray(int[] array){
		for (int i = 0;i<array.length;i++){
			System.out.println(array[i]);
		}
		return array[5];
	}
	public static void main(int j) {
		int k=3;
		int f=showAnimalh(k);
		test jj = new test();
		Animal2 an1 = new Animal2();
		
	}

}
