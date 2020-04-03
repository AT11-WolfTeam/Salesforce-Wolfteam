package salesforce.entities;

import salesforce.entities.constants.EventConstant;
import salesforce.utils.DateFormatter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Manages OpportunityEvent.
 *
 * @author Enrique Carrizales.
 * @version 1.0 02 April 2020.
 */
public class OpportunityEvent {
    private String subject;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private boolean isAllDayEvent;
    private List<Contact> contacts;
    private String relatedTo;
    private String assignedTo;
    private String location;

    /**
     * Gets a subject value.
     *
     * @return a String value.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets a subject value.
     * @param subject contains a String value.
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Gets a startDate value.
     *
     * @return a String value.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets a startDate value.
     * @param startDate contains a String value.
     */
    public void setStartDate(final String startDate) {
        this.startDate = DateFormatter.formatDateUiEvent(startDate);
    }

    /**
     * Gets a endDate value.
     *
     * @return a String value.
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets a endDate value.
     * @param endDate contains a String value.
     */
    public void setEndDate(final String endDate) {
        this.endDate = DateFormatter.formatDateUiEvent(endDate);
    }

    /**
     * Gets a assignedTo value.
     *
     * @return a String value.
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets a assignedTo value.
     * @param assignedTo contains a String value.
     */
    public void setAssignedTo(final String assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * ComposeStrategy to set attributes.
     *
     * @param mapTask map.
     * @return HashMap values.
     */
    private HashMap<String, Runnable> composeStrategy(final Map<String, String> mapTask) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(EventConstant.SUBJECT, () -> setSubject(mapTask.get(EventConstant.SUBJECT)));
        strategyMap.put(EventConstant.START_DATE, () -> setStartDate(mapTask.get(EventConstant.START_DATE)));
        strategyMap.put(EventConstant.END_DATE, () -> setEndDate(mapTask.get(EventConstant.END_DATE)));
        strategyMap.put(EventConstant.ASSIGNED_TO, () -> setAssignedTo(mapTask.get(EventConstant.ASSIGNED_TO)));
        return strategyMap;
    }

    /**
     * Strategy process information.
     *
     * @param mapEventOpportunity map.
     */
    public void processInformation(final Map<String, String> mapEventOpportunity) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapEventOpportunity);
        mapEventOpportunity.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
