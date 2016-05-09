package ed.store.database.structures.serializables;

import ed.store.database.interfaces.Modifiable;
import ed.store.database.structures.SStack;

public class PSStack<T> extends SStack<T>implements Modifiable {

	private transient boolean modifiedFlag = false;
	
	@Override
	public boolean wasModified() {
		return this.modifiedFlag;
	}

	@Override
	public void notifyModification() {
		this.modifiedFlag = true;
	}

	@Override
	public void notifySaving() {
		this.modifiedFlag = false;
	}

}
