package ed.store.database.structures.serializables;

import ed.store.database.interfaces.Modifiable;
import ed.store.database.structures.STable;

public class PSTable extends STable implements Modifiable {

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
