/**
 * 
 */
package com.oc.routing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.oc.cluster.node.NodeID;
import com.oc.core.OcImServer;
import com.oc.session.WaiterSession;
import com.oc.utils.ExternalizableUtil;

/**
 * @Description: 客服信息描述
 * @author chuangyeifang
 * @createDate 2020年1月18日
 * @version v 1.0
 */
public class WaiterRoute implements Externalizable, Route {

	private static final long serialVersionUID = -1013547561230619979L;
	
	private String uid;
	private NodeID nodeID;
	private String version;

	public WaiterRoute() {}
	
	public WaiterRoute(WaiterSession session) {
		this.uid = session.getUid();
		this.nodeID = OcImServer.getInst().getNodeId();
		this.version = session.getVersion();
	}
	
	@Override
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public NodeID getNodeID() {
		return nodeID;
	}

	public void setNodeID(NodeID nodeID) {
		this.nodeID = nodeID;
	}

	@Override
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		ExternalizableUtil.getInstance().writeSafeUTF(out, uid);
		ExternalizableUtil.getInstance().writeSerializable(out, nodeID);
		ExternalizableUtil.getInstance().writeSafeUTF(out, version);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException {
		uid = ExternalizableUtil.getInstance().readSafeUTF(in);
		nodeID = (NodeID)ExternalizableUtil.getInstance().readSerializable(in);
		version = ExternalizableUtil.getInstance().readSafeUTF(in);
	}

	@Override
	public String toString() {
		return "WaiterRoute{" +
				"uid='" + uid + '\'' +
				", nodeID=" + nodeID +
				", version='" + version + '\'' +
				'}';
	}
}
