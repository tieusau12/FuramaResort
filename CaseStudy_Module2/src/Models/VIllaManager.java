package Models;

import java.util.List;

public class VIllaManager {
    List<String> villaManagerList;

    public VIllaManager(List<String> villaManagerList) {
        this.villaManagerList = villaManagerList;
    }

    public List<String> getVillaManagerList() {
        return villaManagerList;
    }

    public void setVillaManagerList(List<String> villaManagerList) {
        this.villaManagerList = villaManagerList;
    }

}
