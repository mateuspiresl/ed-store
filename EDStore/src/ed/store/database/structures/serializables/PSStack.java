package ed.store.database.structures.serializables;

import java.io.Serializable;

import ed.store.database.interfaces.Modifiable;
import ed.store.database.structures.SStack;

public class PSStack<T extends Serializable> extends SStack<T>implements Modifiable {

	private transient boolean modifiedFlag = false;
	
	@Override
	public boolean wasModified() {
		return this.modifiedFlag;
	}

	@Override
	public void notifyChanges() {
		this.modifiedFlag = true;
	}

	@Override
	public void notifySaving() {
		this.modifiedFlag = false;
	}

}
