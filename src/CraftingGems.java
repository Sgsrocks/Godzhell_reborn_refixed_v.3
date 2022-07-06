/**
 * 
 * @author Hood Niqqa
 * credits: phl0w for helping me using enums
 */
public class CraftingGems {
	client c;
	
	public CraftingGems(client c) {
		this.c = c;
	}
public enum craftGems {
	OPAL(1625,1609,1,15),
	JADE(1627,1611,13,20),
	TOPAZ(1629,1613,16,25),
	SAPPHIRE(1623,1607,20,50),
	EMERALD(1621,1605,27,67),
	RUBY(1619,1603,34,85),
	DIAMOND(1617,1601,43,107),
	DRAGONSTONE(1631,1615,55,137),
	ONYX(6571,6573,67,167);
	public int uncutID,cutID,levelReq,exp;
	
	private craftGems(int uncutID, int cutID, int levelReq,int exp) {
		this.uncutID = uncutID;
		this.cutID = cutID;
		this.levelReq = levelReq;
		this.exp = exp;
	}
	public int getUncut() {
		return uncutID;
		
	}
	public int getCut() {
		return cutID;
	}
	public int getLevelReq() {
		return levelReq;
	}
	public int getEXP() {
	return exp;
	}
	}
public void handleChisel(int id1, int id2) {
    cutGem((id1 == 1755) ? id2 : id1);
}
private craftGems forGem(int id) {
	for (craftGems g : craftGems.values()) {
		if (g.getUncut() == id) {
			return g;
		}
	}
	return null;
}


    public void cutGem(int id) {
    	craftGems gem = forGem(id);
    	if (gem != null) {
    		if (c.playerHasItem(gem.getUncut())) {
    			if (c.playerLevel[c.playerCrafting] >= gem.getLevelReq()) {
    				c.deleteItem(gem.getUncut(), 1);
    				c.addItem(gem.getCut(), 1);
    				c.addSkillXP(gem.getEXP(), c.playerCrafting);
    				c.startAnimation(885);
    			} else {
    				c.sendMessage("You need a level of" +gem.getLevelReq()+ "to cut this gem");
    			}
    		}
    	}
    }
}