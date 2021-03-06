package eu.daiad.web.model.message;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import eu.daiad.web.model.DateFormatter;
import eu.daiad.web.model.device.EnumDeviceType;

public abstract class Message {

    public interface Parameters
    {
        public EnumDeviceType getDeviceType();
        
        public DateTime getRefDate();
        
        public Map<String, Object> getPairs();
    }
    
    public abstract static class AbstractParameters implements Parameters
    {
        protected final DateTime refDate;
        
        protected final EnumDeviceType deviceType;
       
        protected AbstractParameters(DateTime refDate, EnumDeviceType deviceType)
        {
            this.refDate = refDate;
            this.deviceType = deviceType;
        }

        @Override
        public DateTime getRefDate()
        {
            return refDate;
        }

        @Override
        public EnumDeviceType getDeviceType()
        {
            return deviceType;
        }
        
        @Override
        public Map<String, Object> getPairs()
        {
            Map<String, Object> p = new HashMap<String, Object>();
            p.put("ref_date", new DateFormatter(refDate));
            p.put("device_type", deviceType);
            return p;    
        }
    }
    
	public abstract EnumMessageType getType();

}
