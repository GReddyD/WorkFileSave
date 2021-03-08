import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
	private static final long serialVersionUID = 1L;
	private int health;
	private int weapons;
	private int lvl;
	private double distance;

	public GameProgress(int health, int weapons, int lvl, double distance) {
		this.health = health;
		this.weapons = weapons;
		this.lvl = lvl;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "GameProgress{" +
						"health=" + health +
						", weapons=" + weapons +
						", lvl=" + lvl +
						", distance=" + distance +
						'}';
	}

	public static void saveGame(String pathFileSave, GameProgress gp) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFileSave + "save.dat", true))) {
			oos.writeObject(gp);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void zipFiles(String pathFileZip, String pathFileSave){
		File dir = new File(pathFileSave);
		if (dir.isDirectory()){
			for (File item : dir.listFiles()) {
				if (item.isFile()) {
					try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathFileZip));
					     FileInputStream fis = new FileInputStream(pathFileSave + "//" + item.getName())) {
						ZipEntry zentry = new ZipEntry(item.getName());
						zout.putNextEntry(zentry);
						byte[] zbuf = new byte[fis.available()];
						fis.read(zbuf);
						zout.write(zbuf);
						zout.closeEntry();
						item.delete();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		}
	}
}