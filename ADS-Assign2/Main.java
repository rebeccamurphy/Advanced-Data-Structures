package vacsys;
public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		
		VacSys a = new VacSys("/home/rebecca/Downloads/testdata/test1M.csv");
		/*
		a.remove();a.remove();a.remove();a.remove();a.remove();
		a.insert("Leopold Banks1",	97,	"48315");
		a.insert("Leopold Bank",	97,	"48315");*/
		a.remove(20, "/home/rebecca/Downloads/testdata/output2.csv");
	}
}
