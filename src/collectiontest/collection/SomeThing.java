package collectiontest.collection;

import java.util.List;

public class SomeThing {
	public List<MapObject> getMapObject() {
		return mapObject;
	}

	@Override
	public String toString() {
		return "SomeThing [mapObject=" + mapObject + "]";
	}

	public void setMapObject(List<MapObject> mapObject) {
		this.mapObject = mapObject;
	}

	public SomeThing(List<MapObject> mapObject) {
		super();
		this.mapObject = mapObject;
	}

	List<MapObject> mapObject;

}
