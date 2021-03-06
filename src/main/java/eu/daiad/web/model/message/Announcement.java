package eu.daiad.web.model.message;

import org.joda.time.DateTime;

import eu.daiad.web.model.device.EnumDeviceType;
import eu.daiad.web.model.message.StaticRecommendation.Parameters;

public class Announcement extends Message 
{
    public interface Parameters extends Message.Parameters {}
    
    public abstract static class AbstractParameters extends Message.AbstractParameters implements Parameters
    {
        protected AbstractParameters(DateTime refDate, EnumDeviceType deviceType)
        {
            super(refDate, deviceType);
        }
    }
    
	private int id;

	private int priority;

	private String title;

	private String content;

	private String link;

	private Long createdOn;
    
    private Long dispatchedOn;

    private Long acknowledgedOn;
    
	@Override
	public EnumMessageType getType() {
		return EnumMessageType.ANNOUNCEMENT;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public Long getDispatchedOn() {
        return dispatchedOn;
    }

    public void setDispatchedOn(Long dispatchedOn) {
        this.dispatchedOn = dispatchedOn;
    }
        
    public Long getAcknowledgedOn() {
        return acknowledgedOn;
    }

    public void setAcknowledgedOn(Long acknowledgedOn) {
        this.acknowledgedOn = acknowledgedOn;
    }
}
