/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;
import java.io.IOException; 
import java.io.Writer; 
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.codehaus.jackson.annotate.JsonIgnoreProperties; 
/** 
* Classe que mapeia o conteúdo da resposta de um request Json-SMD 
* 
* @author "Mário César Kolling" <mario.kolling@serpro.gov.br> 
*/ 
@JsonIgnoreProperties(ignoreUnknown = true) 
public class JsonSMD { 
/** 
* Classe que mapeia os serviços que o Expresso3 suporta 
*/ 
public static class Service { 
private String _envelope, _transport; 
private Object _returns; 
private ArrayList<Object> _parameters; 
public String getEnvelope() { 
return _envelope; 
} 
public ArrayList<Object> getParameters() { 
return _parameters; 
} 
public String getTransport() { 
return _transport; 
} 
public Object getReturns() { 
return _returns; 
} 
public void setEnvelope(String _envelope) { 
this._envelope = _envelope; 
} 
public void setParameters(ArrayList<Object> _parameters) { 
this._parameters = _parameters; 
} 
public void setTransport(String _transport) { 
this._transport = _transport; 
} 
public void setReturns(Object returns) { 
this._returns = returns; 
} 
} 
private Double _SMDVersion; 
private String _transport, _envelope, _contentType, _target; 
private Map<String, Service> _services; 
public Double getSMDVersion() { 
return _SMDVersion; 
} 
public String getContentType() { 
return _contentType; 
} 
public String getEnvelope() { 
return _envelope; 
} 
public Map<String, Service> getServices() { 
return _services; 
} 
public String getTarget() { 
return _target; 
} 
public String getTransport() { 
return _transport; 
}
public void setSMDVersion(Double _SMDVersion) { 
this._SMDVersion = _SMDVersion; 
} 
public void setContentType(String _contentType) { 
this._contentType = _contentType; 
} 
public void setEnvelope(String _envelope) { 
this._envelope = _envelope; 
} 
public void setServices(Map<String, Service> _services) { 
this._services = _services; 
} 
public void setTarget(String _target) { 
this._target = _target; 
} 
public void setTransport(String _transport) { 
this._transport = _transport; 
} 
/** 
* Imprime o conteúdo desta resposta 
*/ 
@SuppressWarnings("empty-statement") 
public void printContent() { 
System.out.println("Transport: " + this.getTransport()); 
System.out.println("Envelope: " + this.getEnvelope()); 
System.out.println("ContentType: " + this.getContentType()); 
System.out.println("Target: " + this.getTarget()); 
System.out.println("Services: "); 
for (Iterator<String> i = getServices().keySet().iterator(); i.hasNext();){ 
String serviceName = i.next(); 
System.out.println("\t"+serviceName+": "); 
System.out.println("\t\tTransport: " + 
getServices().get(serviceName).getTransport()); 
System.out.println("\t\tEnvelope: " + 
getServices().get(serviceName).getEnvelope()); 
System.out.println("\t\tReturns: " + getServices().get(serviceName).getReturns()); 
System.out.println("\t\tParameters: "); 
for (Object params : getServices().get(serviceName).getParameters()){ 
if (params instanceof LinkedHashMap) { 
LinkedHashMap<String, Object> lhm = (LinkedHashMap<String, Object>) 
params; 
for (Iterator<String> j = lhm.keySet().iterator(); j.hasNext();) { 
String paramKey = j.next(); 
System.out.println("\t\t\t"+paramKey+": "+lhm.get(paramKey)); 
} 
} 
} 
} 
} 
/** 
* Escreve o conteúdo desta resposta em um writer 
* 
* @param writer Para onde escreveremos 
* @throws IOException 
*/ 
public void writeContent(Writer writer) throws IOException { 
writer.write("Transport: " + this.getTransport()); writer.write('\n'); 
writer.write("Envelope: " + this.getEnvelope()); writer.write('\n'); 
writer.write("ContentType: " + this.getContentType()); writer.write('\n'); 
writer.write("Target: " + this.getTarget()); writer.write('\n'); 
writer.write("Services: "); writer.write('\n'); 
for (Iterator<String> i = getServices().keySet().iterator(); i.hasNext();){ 
String serviceName = i.next(); 
writer.write("\t"+serviceName+": "); writer.write('\n'); 
writer.write("\t\tTransport: " + getServices().get(serviceName).getTransport()); 
writer.write('\n'); 
writer.write("\t\tEnvelope: " + getServices().get(serviceName).getEnvelope()); 
writer.write('\n'); 
writer.write("\t\tReturns: " + getServices().get(serviceName).getReturns()); 
writer.write('\n'); 
writer.write("\t\tParameters: "); writer.write('\n'); 
for (Object params : getServices().get(serviceName).getParameters()){ 
if (params instanceof LinkedHashMap) { 
LinkedHashMap<String, Object> lhm = (LinkedHashMap<String, Object>) 
params; 
for (Iterator<String> j = lhm.keySet().iterator(); j.hasNext();) { 
String paramKey = j.next(); 
writer.write("\t\t\t"+paramKey+": "+lhm.get(paramKey)); writer.write('\n'); 
} 
writer.write('\n'); 
} 
} 
} 
writer.close(); 
} 
} 
