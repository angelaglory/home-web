package eu.daiad.web.domain.application;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import eu.daiad.web.model.group.EnumGroupType;

@Entity(name = "group_segment")
@Table(schema = "public", name = "group_segment")
public class GroupSegmentEntity extends GroupEntity {

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cluster_id", nullable = false)
	private ClusterEntity cluster;

	@Override
	public EnumGroupType getType() {
		return EnumGroupType.SEGMENT;
	}

	public ClusterEntity getCluster() {
		return cluster;
	}

	public void setCluster(ClusterEntity cluster) {
		this.cluster = cluster;
	}

}
