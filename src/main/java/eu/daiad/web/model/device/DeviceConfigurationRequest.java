package eu.daiad.web.model.device;

import java.util.UUID;

import eu.daiad.web.model.AuthenticatedRequest;

public class DeviceConfigurationRequest extends AuthenticatedRequest {

	private UUID deviceKey[];

	public UUID[] getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(UUID[] deviceKey) {
		this.deviceKey = deviceKey;
	}

}
