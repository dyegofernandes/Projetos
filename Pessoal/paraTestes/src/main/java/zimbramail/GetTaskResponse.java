
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getTaskResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getTaskResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="appt" type="{urn:zimbraMail}calendarItemInfo"/>
 *           &lt;element name="task" type="{urn:zimbraMail}taskItemInfo"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTaskResponse", propOrder = {
    "appt",
    "task"
})
public class GetTaskResponse {

    protected CalendarItemInfo appt;
    protected TaskItemInfo task;

    /**
     * Obtém o valor da propriedade appt.
     * 
     * @return
     *     possible object is
     *     {@link CalendarItemInfo }
     *     
     */
    public CalendarItemInfo getAppt() {
        return appt;
    }

    /**
     * Define o valor da propriedade appt.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarItemInfo }
     *     
     */
    public void setAppt(CalendarItemInfo value) {
        this.appt = value;
    }

    /**
     * Obtém o valor da propriedade task.
     * 
     * @return
     *     possible object is
     *     {@link TaskItemInfo }
     *     
     */
    public TaskItemInfo getTask() {
        return task;
    }

    /**
     * Define o valor da propriedade task.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskItemInfo }
     *     
     */
    public void setTask(TaskItemInfo value) {
        this.task = value;
    }

}
