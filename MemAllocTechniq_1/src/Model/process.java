package Model;

public class process {
int process_id;
int mem_size;
boolean ff_status;
boolean bf_status;
boolean wf_status;
public boolean isWf_status() {
	return wf_status;
}
public void setWf_status(boolean wf_status) {
	this.wf_status = wf_status;
}
public boolean isNf_status() {
	return nf_status;
}
public void setNf_status(boolean nf_status) {
	this.nf_status = nf_status;
}
boolean nf_status;

public boolean isFf_status() {
	return ff_status;
}
public void setFf_status(boolean ff_status) {
	this.ff_status = ff_status;
}
public boolean isBf_status() {
	return bf_status;
}
public void setBf_status(boolean bf_status) {
	this.bf_status = bf_status;
}



/*public boolean getStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}*/
public int getProcess_id() {
	return process_id;
}
public void setProcess_id(int process_id) {
	this.process_id = process_id;
}
public int getMem_size() {
	return mem_size;
}
public void setMem_size(int mem_size) {
	this.mem_size = mem_size;
}

}
