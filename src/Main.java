public class Main {
  public static void main(String[] args) {
    String pathFileSave = "/Users/greddyd/IdeaProjects/WorkFileSave/Games/savegames/";
    String pathFileZip = "/Users/greddyd/IdeaProjects/WorkFileSave/Games/savegames/zip.zip";
    GameProgress.saveGame(pathFileSave, new GameProgress(100, 2, 20, 10.0));
    GameProgress.saveGame(pathFileSave, new GameProgress(50, 1, 35, 1000.0));
    GameProgress.saveGame(pathFileSave, new GameProgress(30, 5, 50, 50.0));
    GameProgress.zipFiles(pathFileZip, pathFileSave);
  }

}
