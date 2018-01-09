
package zimbravoice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zimbravoice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ResetVoiceFeaturesRequest_QNAME = new QName("urn:zimbraVoice", "ResetVoiceFeaturesRequest");
    private final static QName _ChangeUCPasswordRequest_QNAME = new QName("urn:zimbraVoice", "ChangeUCPasswordRequest");
    private final static QName _UploadVoiceMailResponse_QNAME = new QName("urn:zimbraVoice", "UploadVoiceMailResponse");
    private final static QName _GetVoiceMailPrefsRequest_QNAME = new QName("urn:zimbraVoice", "GetVoiceMailPrefsRequest");
    private final static QName _GetVoiceFolderResponse_QNAME = new QName("urn:zimbraVoice", "GetVoiceFolderResponse");
    private final static QName _ModifyVoiceMailPinResponse_QNAME = new QName("urn:zimbraVoice", "ModifyVoiceMailPinResponse");
    private final static QName _SearchVoiceResponse_QNAME = new QName("urn:zimbraVoice", "SearchVoiceResponse");
    private final static QName _ModifyVoiceFeaturesRequest_QNAME = new QName("urn:zimbraVoice", "ModifyVoiceFeaturesRequest");
    private final static QName _GetVoiceFeaturesResponse_QNAME = new QName("urn:zimbraVoice", "GetVoiceFeaturesResponse");
    private final static QName _ModifyVoiceMailPrefsRequest_QNAME = new QName("urn:zimbraVoice", "ModifyVoiceMailPrefsRequest");
    private final static QName _ResetVoiceFeaturesResponse_QNAME = new QName("urn:zimbraVoice", "ResetVoiceFeaturesResponse");
    private final static QName _ModifyFromNumResponse_QNAME = new QName("urn:zimbraVoice", "ModifyFromNumResponse");
    private final static QName _GetVoiceFeaturesRequest_QNAME = new QName("urn:zimbraVoice", "GetVoiceFeaturesRequest");
    private final static QName _GetVoiceFolderRequest_QNAME = new QName("urn:zimbraVoice", "GetVoiceFolderRequest");
    private final static QName _ModifyVoiceMailPrefsResponse_QNAME = new QName("urn:zimbraVoice", "ModifyVoiceMailPrefsResponse");
    private final static QName _GetVoiceInfoResponse_QNAME = new QName("urn:zimbraVoice", "GetVoiceInfoResponse");
    private final static QName _UploadVoiceMailRequest_QNAME = new QName("urn:zimbraVoice", "UploadVoiceMailRequest");
    private final static QName _GetUCInfoRequest_QNAME = new QName("urn:zimbraVoice", "GetUCInfoRequest");
    private final static QName _VoiceMsgActionResponse_QNAME = new QName("urn:zimbraVoice", "VoiceMsgActionResponse");
    private final static QName _SearchVoiceRequest_QNAME = new QName("urn:zimbraVoice", "SearchVoiceRequest");
    private final static QName _GetVoiceMailPrefsResponse_QNAME = new QName("urn:zimbraVoice", "GetVoiceMailPrefsResponse");
    private final static QName _VoiceMsgActionRequest_QNAME = new QName("urn:zimbraVoice", "VoiceMsgActionRequest");
    private final static QName _GetVoiceInfoRequest_QNAME = new QName("urn:zimbraVoice", "GetVoiceInfoRequest");
    private final static QName _ModifyVoiceFeaturesResponse_QNAME = new QName("urn:zimbraVoice", "ModifyVoiceFeaturesResponse");
    private final static QName _GetUCInfoResponse_QNAME = new QName("urn:zimbraVoice", "GetUCInfoResponse");
    private final static QName _ChangeUCPasswordResponse_QNAME = new QName("urn:zimbraVoice", "ChangeUCPasswordResponse");
    private final static QName _ModifyFromNumRequest_QNAME = new QName("urn:zimbraVoice", "ModifyFromNumRequest");
    private final static QName _ModifyVoiceMailPinRequest_QNAME = new QName("urn:zimbraVoice", "ModifyVoiceMailPinRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zimbravoice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VoiceInfo }
     * 
     */
    public VoiceInfo createVoiceInfo() {
        return new VoiceInfo();
    }

    /**
     * Create an instance of {@link GetUCInfoResponse }
     * 
     */
    public GetUCInfoResponse createGetUCInfoResponse() {
        return new GetUCInfoResponse();
    }

    /**
     * Create an instance of {@link ResetVoiceFeaturesRequest }
     * 
     */
    public ResetVoiceFeaturesRequest createResetVoiceFeaturesRequest() {
        return new ResetVoiceFeaturesRequest();
    }

    /**
     * Create an instance of {@link SearchVoiceResponse }
     * 
     */
    public SearchVoiceResponse createSearchVoiceResponse() {
        return new SearchVoiceResponse();
    }

    /**
     * Create an instance of {@link GetVoiceMailPrefsResponse }
     * 
     */
    public GetVoiceMailPrefsResponse createGetVoiceMailPrefsResponse() {
        return new GetVoiceMailPrefsResponse();
    }

    /**
     * Create an instance of {@link ModifyVoiceFeaturesRequest }
     * 
     */
    public ModifyVoiceFeaturesRequest createModifyVoiceFeaturesRequest() {
        return new ModifyVoiceFeaturesRequest();
    }

    /**
     * Create an instance of {@link ModifyFromNumRequest }
     * 
     */
    public ModifyFromNumRequest createModifyFromNumRequest() {
        return new ModifyFromNumRequest();
    }

    /**
     * Create an instance of {@link ModifyVoiceMailPrefsRequest }
     * 
     */
    public ModifyVoiceMailPrefsRequest createModifyVoiceMailPrefsRequest() {
        return new ModifyVoiceMailPrefsRequest();
    }

    /**
     * Create an instance of {@link GetVoiceMailPrefsRequest }
     * 
     */
    public GetVoiceMailPrefsRequest createGetVoiceMailPrefsRequest() {
        return new GetVoiceMailPrefsRequest();
    }

    /**
     * Create an instance of {@link VoiceMsgActionRequest }
     * 
     */
    public VoiceMsgActionRequest createVoiceMsgActionRequest() {
        return new VoiceMsgActionRequest();
    }

    /**
     * Create an instance of {@link ModifyVoiceFeaturesResponse }
     * 
     */
    public ModifyVoiceFeaturesResponse createModifyVoiceFeaturesResponse() {
        return new ModifyVoiceFeaturesResponse();
    }

    /**
     * Create an instance of {@link ResetVoiceFeaturesResponse }
     * 
     */
    public ResetVoiceFeaturesResponse createResetVoiceFeaturesResponse() {
        return new ResetVoiceFeaturesResponse();
    }

    /**
     * Create an instance of {@link ModifyVoiceMailPinResponse }
     * 
     */
    public ModifyVoiceMailPinResponse createModifyVoiceMailPinResponse() {
        return new ModifyVoiceMailPinResponse();
    }

    /**
     * Create an instance of {@link VoiceMsgActionResponse }
     * 
     */
    public VoiceMsgActionResponse createVoiceMsgActionResponse() {
        return new VoiceMsgActionResponse();
    }

    /**
     * Create an instance of {@link ChangeUCPasswordResponse }
     * 
     */
    public ChangeUCPasswordResponse createChangeUCPasswordResponse() {
        return new ChangeUCPasswordResponse();
    }

    /**
     * Create an instance of {@link GetVoiceInfoRequest }
     * 
     */
    public GetVoiceInfoRequest createGetVoiceInfoRequest() {
        return new GetVoiceInfoRequest();
    }

    /**
     * Create an instance of {@link GetVoiceFolderRequest }
     * 
     */
    public GetVoiceFolderRequest createGetVoiceFolderRequest() {
        return new GetVoiceFolderRequest();
    }

    /**
     * Create an instance of {@link ModifyVoiceMailPrefsResponse }
     * 
     */
    public ModifyVoiceMailPrefsResponse createModifyVoiceMailPrefsResponse() {
        return new ModifyVoiceMailPrefsResponse();
    }

    /**
     * Create an instance of {@link GetVoiceFolderResponse }
     * 
     */
    public GetVoiceFolderResponse createGetVoiceFolderResponse() {
        return new GetVoiceFolderResponse();
    }

    /**
     * Create an instance of {@link GetVoiceInfoResponse }
     * 
     */
    public GetVoiceInfoResponse createGetVoiceInfoResponse() {
        return new GetVoiceInfoResponse();
    }

    /**
     * Create an instance of {@link GetUCInfoRequest }
     * 
     */
    public GetUCInfoRequest createGetUCInfoRequest() {
        return new GetUCInfoRequest();
    }

    /**
     * Create an instance of {@link GetVoiceFeaturesRequest }
     * 
     */
    public GetVoiceFeaturesRequest createGetVoiceFeaturesRequest() {
        return new GetVoiceFeaturesRequest();
    }

    /**
     * Create an instance of {@link ChangeUCPasswordRequest }
     * 
     */
    public ChangeUCPasswordRequest createChangeUCPasswordRequest() {
        return new ChangeUCPasswordRequest();
    }

    /**
     * Create an instance of {@link UploadVoiceMailRequest }
     * 
     */
    public UploadVoiceMailRequest createUploadVoiceMailRequest() {
        return new UploadVoiceMailRequest();
    }

    /**
     * Create an instance of {@link UploadVoiceMailResponse }
     * 
     */
    public UploadVoiceMailResponse createUploadVoiceMailResponse() {
        return new UploadVoiceMailResponse();
    }

    /**
     * Create an instance of {@link ModifyVoiceMailPinRequest }
     * 
     */
    public ModifyVoiceMailPinRequest createModifyVoiceMailPinRequest() {
        return new ModifyVoiceMailPinRequest();
    }

    /**
     * Create an instance of {@link SearchVoiceRequest }
     * 
     */
    public SearchVoiceRequest createSearchVoiceRequest() {
        return new SearchVoiceRequest();
    }

    /**
     * Create an instance of {@link GetVoiceFeaturesResponse }
     * 
     */
    public GetVoiceFeaturesResponse createGetVoiceFeaturesResponse() {
        return new GetVoiceFeaturesResponse();
    }

    /**
     * Create an instance of {@link ModifyFromNumResponse }
     * 
     */
    public ModifyFromNumResponse createModifyFromNumResponse() {
        return new ModifyFromNumResponse();
    }

    /**
     * Create an instance of {@link VoiceMsgUploadInfo }
     * 
     */
    public VoiceMsgUploadInfo createVoiceMsgUploadInfo() {
        return new VoiceMsgUploadInfo();
    }

    /**
     * Create an instance of {@link VoiceMailContent }
     * 
     */
    public VoiceMailContent createVoiceMailContent() {
        return new VoiceMailContent();
    }

    /**
     * Create an instance of {@link CallWaitingFeature }
     * 
     */
    public CallWaitingFeature createCallWaitingFeature() {
        return new CallWaitingFeature();
    }

    /**
     * Create an instance of {@link CallerIdBlockingReq }
     * 
     */
    public CallerIdBlockingReq createCallerIdBlockingReq() {
        return new CallerIdBlockingReq();
    }

    /**
     * Create an instance of {@link SelectiveCallRejectionFeature }
     * 
     */
    public SelectiveCallRejectionFeature createSelectiveCallRejectionFeature() {
        return new SelectiveCallRejectionFeature();
    }

    /**
     * Create an instance of {@link VoiceMsgUploadSpec }
     * 
     */
    public VoiceMsgUploadSpec createVoiceMsgUploadSpec() {
        return new VoiceMsgUploadSpec();
    }

    /**
     * Create an instance of {@link CallForwardNoAnswerFeature }
     * 
     */
    public CallForwardNoAnswerFeature createCallForwardNoAnswerFeature() {
        return new CallForwardNoAnswerFeature();
    }

    /**
     * Create an instance of {@link CallLogItem }
     * 
     */
    public CallLogItem createCallLogItem() {
        return new CallLogItem();
    }

    /**
     * Create an instance of {@link VoiceMailPrefsFeature }
     * 
     */
    public VoiceMailPrefsFeature createVoiceMailPrefsFeature() {
        return new VoiceMailPrefsFeature();
    }

    /**
     * Create an instance of {@link ModifyFromNumSpec }
     * 
     */
    public ModifyFromNumSpec createModifyFromNumSpec() {
        return new ModifyFromNumSpec();
    }

    /**
     * Create an instance of {@link PhoneInfo }
     * 
     */
    public PhoneInfo createPhoneInfo() {
        return new PhoneInfo();
    }

    /**
     * Create an instance of {@link VoiceFolderSummary }
     * 
     */
    public VoiceFolderSummary createVoiceFolderSummary() {
        return new VoiceFolderSummary();
    }

    /**
     * Create an instance of {@link SelectiveCallForwardReq }
     * 
     */
    public SelectiveCallForwardReq createSelectiveCallForwardReq() {
        return new SelectiveCallForwardReq();
    }

    /**
     * Create an instance of {@link StorePrincipalSpec }
     * 
     */
    public StorePrincipalSpec createStorePrincipalSpec() {
        return new StorePrincipalSpec();
    }

    /**
     * Create an instance of {@link ModifyVoiceMailPinSpec }
     * 
     */
    public ModifyVoiceMailPinSpec createModifyVoiceMailPinSpec() {
        return new ModifyVoiceMailPinSpec();
    }

    /**
     * Create an instance of {@link SelectiveCallAcceptanceFeature }
     * 
     */
    public SelectiveCallAcceptanceFeature createSelectiveCallAcceptanceFeature() {
        return new SelectiveCallAcceptanceFeature();
    }

    /**
     * Create an instance of {@link VoiceMsgActionInfo }
     * 
     */
    public VoiceMsgActionInfo createVoiceMsgActionInfo() {
        return new VoiceMsgActionInfo();
    }

    /**
     * Create an instance of {@link PhoneVoiceFeaturesInfo }
     * 
     */
    public PhoneVoiceFeaturesInfo createPhoneVoiceFeaturesInfo() {
        return new PhoneVoiceFeaturesInfo();
    }

    /**
     * Create an instance of {@link CallForwardFeature }
     * 
     */
    public CallForwardFeature createCallForwardFeature() {
        return new CallForwardFeature();
    }

    /**
     * Create an instance of {@link CallForwardNoAnswerReq }
     * 
     */
    public CallForwardNoAnswerReq createCallForwardNoAnswerReq() {
        return new CallForwardNoAnswerReq();
    }

    /**
     * Create an instance of {@link PhoneName }
     * 
     */
    public PhoneName createPhoneName() {
        return new PhoneName();
    }

    /**
     * Create an instance of {@link SelectiveCallAcceptanceReq }
     * 
     */
    public SelectiveCallAcceptanceReq createSelectiveCallAcceptanceReq() {
        return new SelectiveCallAcceptanceReq();
    }

    /**
     * Create an instance of {@link CallerListEntry }
     * 
     */
    public CallerListEntry createCallerListEntry() {
        return new CallerListEntry();
    }

    /**
     * Create an instance of {@link VoiceFolder }
     * 
     */
    public VoiceFolder createVoiceFolder() {
        return new VoiceFolder();
    }

    /**
     * Create an instance of {@link CallForwardBusyLineReq }
     * 
     */
    public CallForwardBusyLineReq createCallForwardBusyLineReq() {
        return new CallForwardBusyLineReq();
    }

    /**
     * Create an instance of {@link CallFeature }
     * 
     */
    public CallFeature createCallFeature() {
        return new CallFeature();
    }

    /**
     * Create an instance of {@link CallForwardReq }
     * 
     */
    public CallForwardReq createCallForwardReq() {
        return new CallForwardReq();
    }

    /**
     * Create an instance of {@link VoiceCallItem }
     * 
     */
    public VoiceCallItem createVoiceCallItem() {
        return new VoiceCallItem();
    }

    /**
     * Create an instance of {@link VoiceMailCallParty }
     * 
     */
    public VoiceMailCallParty createVoiceMailCallParty() {
        return new VoiceMailCallParty();
    }

    /**
     * Create an instance of {@link VoiceMailPrefsReq }
     * 
     */
    public VoiceMailPrefsReq createVoiceMailPrefsReq() {
        return new VoiceMailPrefsReq();
    }

    /**
     * Create an instance of {@link CallLogCallParty }
     * 
     */
    public CallLogCallParty createCallLogCallParty() {
        return new CallLogCallParty();
    }

    /**
     * Create an instance of {@link PrefInfo }
     * 
     */
    public PrefInfo createPrefInfo() {
        return new PrefInfo();
    }

    /**
     * Create an instance of {@link PrefSpec }
     * 
     */
    public PrefSpec createPrefSpec() {
        return new PrefSpec();
    }

    /**
     * Create an instance of {@link CallWaitingReq }
     * 
     */
    public CallWaitingReq createCallWaitingReq() {
        return new CallWaitingReq();
    }

    /**
     * Create an instance of {@link Attr }
     * 
     */
    public Attr createAttr() {
        return new Attr();
    }

    /**
     * Create an instance of {@link PhoneVoiceFeaturesSpec }
     * 
     */
    public PhoneVoiceFeaturesSpec createPhoneVoiceFeaturesSpec() {
        return new PhoneVoiceFeaturesSpec();
    }

    /**
     * Create an instance of {@link AnonCallRejectionFeature }
     * 
     */
    public AnonCallRejectionFeature createAnonCallRejectionFeature() {
        return new AnonCallRejectionFeature();
    }

    /**
     * Create an instance of {@link VoiceMsgActionSpec }
     * 
     */
    public VoiceMsgActionSpec createVoiceMsgActionSpec() {
        return new VoiceMsgActionSpec();
    }

    /**
     * Create an instance of {@link VoiceMailPrefName }
     * 
     */
    public VoiceMailPrefName createVoiceMailPrefName() {
        return new VoiceMailPrefName();
    }

    /**
     * Create an instance of {@link CallerIdBlockingFeature }
     * 
     */
    public CallerIdBlockingFeature createCallerIdBlockingFeature() {
        return new CallerIdBlockingFeature();
    }

    /**
     * Create an instance of {@link AnonCallRejectionReq }
     * 
     */
    public AnonCallRejectionReq createAnonCallRejectionReq() {
        return new AnonCallRejectionReq();
    }

    /**
     * Create an instance of {@link PhoneSpec }
     * 
     */
    public PhoneSpec createPhoneSpec() {
        return new PhoneSpec();
    }

    /**
     * Create an instance of {@link VoiceFolderInfo }
     * 
     */
    public VoiceFolderInfo createVoiceFolderInfo() {
        return new VoiceFolderInfo();
    }

    /**
     * Create an instance of {@link VoiceMailItem }
     * 
     */
    public VoiceMailItem createVoiceMailItem() {
        return new VoiceMailItem();
    }

    /**
     * Create an instance of {@link ResetPhoneVoiceFeaturesSpec }
     * 
     */
    public ResetPhoneVoiceFeaturesSpec createResetPhoneVoiceFeaturesSpec() {
        return new ResetPhoneVoiceFeaturesSpec();
    }

    /**
     * Create an instance of {@link FeatureWithCallerList }
     * 
     */
    public FeatureWithCallerList createFeatureWithCallerList() {
        return new FeatureWithCallerList();
    }

    /**
     * Create an instance of {@link RootVoiceFolder }
     * 
     */
    public RootVoiceFolder createRootVoiceFolder() {
        return new RootVoiceFolder();
    }

    /**
     * Create an instance of {@link ModifyVoiceFeaturesSpec }
     * 
     */
    public ModifyVoiceFeaturesSpec createModifyVoiceFeaturesSpec() {
        return new ModifyVoiceFeaturesSpec();
    }

    /**
     * Create an instance of {@link SelectiveCallForwardFeature }
     * 
     */
    public SelectiveCallForwardFeature createSelectiveCallForwardFeature() {
        return new SelectiveCallForwardFeature();
    }

    /**
     * Create an instance of {@link CallForwardBusyLineFeature }
     * 
     */
    public CallForwardBusyLineFeature createCallForwardBusyLineFeature() {
        return new CallForwardBusyLineFeature();
    }

    /**
     * Create an instance of {@link SelectiveCallRejectionReq }
     * 
     */
    public SelectiveCallRejectionReq createSelectiveCallRejectionReq() {
        return new SelectiveCallRejectionReq();
    }

    /**
     * Create an instance of {@link VoiceInfo.Callfeatures }
     * 
     */
    public VoiceInfo.Callfeatures createVoiceInfoCallfeatures() {
        return new VoiceInfo.Callfeatures();
    }

    /**
     * Create an instance of {@link GetUCInfoResponse.Attrs }
     * 
     */
    public GetUCInfoResponse.Attrs createGetUCInfoResponseAttrs() {
        return new GetUCInfoResponse.Attrs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetVoiceFeaturesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ResetVoiceFeaturesRequest")
    public JAXBElement<ResetVoiceFeaturesRequest> createResetVoiceFeaturesRequest(ResetVoiceFeaturesRequest value) {
        return new JAXBElement<ResetVoiceFeaturesRequest>(_ResetVoiceFeaturesRequest_QNAME, ResetVoiceFeaturesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeUCPasswordRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ChangeUCPasswordRequest")
    public JAXBElement<ChangeUCPasswordRequest> createChangeUCPasswordRequest(ChangeUCPasswordRequest value) {
        return new JAXBElement<ChangeUCPasswordRequest>(_ChangeUCPasswordRequest_QNAME, ChangeUCPasswordRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadVoiceMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "UploadVoiceMailResponse")
    public JAXBElement<UploadVoiceMailResponse> createUploadVoiceMailResponse(UploadVoiceMailResponse value) {
        return new JAXBElement<UploadVoiceMailResponse>(_UploadVoiceMailResponse_QNAME, UploadVoiceMailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceMailPrefsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceMailPrefsRequest")
    public JAXBElement<GetVoiceMailPrefsRequest> createGetVoiceMailPrefsRequest(GetVoiceMailPrefsRequest value) {
        return new JAXBElement<GetVoiceMailPrefsRequest>(_GetVoiceMailPrefsRequest_QNAME, GetVoiceMailPrefsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceFolderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceFolderResponse")
    public JAXBElement<GetVoiceFolderResponse> createGetVoiceFolderResponse(GetVoiceFolderResponse value) {
        return new JAXBElement<GetVoiceFolderResponse>(_GetVoiceFolderResponse_QNAME, GetVoiceFolderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyVoiceMailPinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyVoiceMailPinResponse")
    public JAXBElement<ModifyVoiceMailPinResponse> createModifyVoiceMailPinResponse(ModifyVoiceMailPinResponse value) {
        return new JAXBElement<ModifyVoiceMailPinResponse>(_ModifyVoiceMailPinResponse_QNAME, ModifyVoiceMailPinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchVoiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "SearchVoiceResponse")
    public JAXBElement<SearchVoiceResponse> createSearchVoiceResponse(SearchVoiceResponse value) {
        return new JAXBElement<SearchVoiceResponse>(_SearchVoiceResponse_QNAME, SearchVoiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyVoiceFeaturesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyVoiceFeaturesRequest")
    public JAXBElement<ModifyVoiceFeaturesRequest> createModifyVoiceFeaturesRequest(ModifyVoiceFeaturesRequest value) {
        return new JAXBElement<ModifyVoiceFeaturesRequest>(_ModifyVoiceFeaturesRequest_QNAME, ModifyVoiceFeaturesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceFeaturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceFeaturesResponse")
    public JAXBElement<GetVoiceFeaturesResponse> createGetVoiceFeaturesResponse(GetVoiceFeaturesResponse value) {
        return new JAXBElement<GetVoiceFeaturesResponse>(_GetVoiceFeaturesResponse_QNAME, GetVoiceFeaturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyVoiceMailPrefsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyVoiceMailPrefsRequest")
    public JAXBElement<ModifyVoiceMailPrefsRequest> createModifyVoiceMailPrefsRequest(ModifyVoiceMailPrefsRequest value) {
        return new JAXBElement<ModifyVoiceMailPrefsRequest>(_ModifyVoiceMailPrefsRequest_QNAME, ModifyVoiceMailPrefsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResetVoiceFeaturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ResetVoiceFeaturesResponse")
    public JAXBElement<ResetVoiceFeaturesResponse> createResetVoiceFeaturesResponse(ResetVoiceFeaturesResponse value) {
        return new JAXBElement<ResetVoiceFeaturesResponse>(_ResetVoiceFeaturesResponse_QNAME, ResetVoiceFeaturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyFromNumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyFromNumResponse")
    public JAXBElement<ModifyFromNumResponse> createModifyFromNumResponse(ModifyFromNumResponse value) {
        return new JAXBElement<ModifyFromNumResponse>(_ModifyFromNumResponse_QNAME, ModifyFromNumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceFeaturesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceFeaturesRequest")
    public JAXBElement<GetVoiceFeaturesRequest> createGetVoiceFeaturesRequest(GetVoiceFeaturesRequest value) {
        return new JAXBElement<GetVoiceFeaturesRequest>(_GetVoiceFeaturesRequest_QNAME, GetVoiceFeaturesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceFolderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceFolderRequest")
    public JAXBElement<GetVoiceFolderRequest> createGetVoiceFolderRequest(GetVoiceFolderRequest value) {
        return new JAXBElement<GetVoiceFolderRequest>(_GetVoiceFolderRequest_QNAME, GetVoiceFolderRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyVoiceMailPrefsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyVoiceMailPrefsResponse")
    public JAXBElement<ModifyVoiceMailPrefsResponse> createModifyVoiceMailPrefsResponse(ModifyVoiceMailPrefsResponse value) {
        return new JAXBElement<ModifyVoiceMailPrefsResponse>(_ModifyVoiceMailPrefsResponse_QNAME, ModifyVoiceMailPrefsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceInfoResponse")
    public JAXBElement<GetVoiceInfoResponse> createGetVoiceInfoResponse(GetVoiceInfoResponse value) {
        return new JAXBElement<GetVoiceInfoResponse>(_GetVoiceInfoResponse_QNAME, GetVoiceInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadVoiceMailRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "UploadVoiceMailRequest")
    public JAXBElement<UploadVoiceMailRequest> createUploadVoiceMailRequest(UploadVoiceMailRequest value) {
        return new JAXBElement<UploadVoiceMailRequest>(_UploadVoiceMailRequest_QNAME, UploadVoiceMailRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUCInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetUCInfoRequest")
    public JAXBElement<GetUCInfoRequest> createGetUCInfoRequest(GetUCInfoRequest value) {
        return new JAXBElement<GetUCInfoRequest>(_GetUCInfoRequest_QNAME, GetUCInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoiceMsgActionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "VoiceMsgActionResponse")
    public JAXBElement<VoiceMsgActionResponse> createVoiceMsgActionResponse(VoiceMsgActionResponse value) {
        return new JAXBElement<VoiceMsgActionResponse>(_VoiceMsgActionResponse_QNAME, VoiceMsgActionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchVoiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "SearchVoiceRequest")
    public JAXBElement<SearchVoiceRequest> createSearchVoiceRequest(SearchVoiceRequest value) {
        return new JAXBElement<SearchVoiceRequest>(_SearchVoiceRequest_QNAME, SearchVoiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceMailPrefsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceMailPrefsResponse")
    public JAXBElement<GetVoiceMailPrefsResponse> createGetVoiceMailPrefsResponse(GetVoiceMailPrefsResponse value) {
        return new JAXBElement<GetVoiceMailPrefsResponse>(_GetVoiceMailPrefsResponse_QNAME, GetVoiceMailPrefsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoiceMsgActionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "VoiceMsgActionRequest")
    public JAXBElement<VoiceMsgActionRequest> createVoiceMsgActionRequest(VoiceMsgActionRequest value) {
        return new JAXBElement<VoiceMsgActionRequest>(_VoiceMsgActionRequest_QNAME, VoiceMsgActionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoiceInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetVoiceInfoRequest")
    public JAXBElement<GetVoiceInfoRequest> createGetVoiceInfoRequest(GetVoiceInfoRequest value) {
        return new JAXBElement<GetVoiceInfoRequest>(_GetVoiceInfoRequest_QNAME, GetVoiceInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyVoiceFeaturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyVoiceFeaturesResponse")
    public JAXBElement<ModifyVoiceFeaturesResponse> createModifyVoiceFeaturesResponse(ModifyVoiceFeaturesResponse value) {
        return new JAXBElement<ModifyVoiceFeaturesResponse>(_ModifyVoiceFeaturesResponse_QNAME, ModifyVoiceFeaturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUCInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "GetUCInfoResponse")
    public JAXBElement<GetUCInfoResponse> createGetUCInfoResponse(GetUCInfoResponse value) {
        return new JAXBElement<GetUCInfoResponse>(_GetUCInfoResponse_QNAME, GetUCInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeUCPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ChangeUCPasswordResponse")
    public JAXBElement<ChangeUCPasswordResponse> createChangeUCPasswordResponse(ChangeUCPasswordResponse value) {
        return new JAXBElement<ChangeUCPasswordResponse>(_ChangeUCPasswordResponse_QNAME, ChangeUCPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyFromNumRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyFromNumRequest")
    public JAXBElement<ModifyFromNumRequest> createModifyFromNumRequest(ModifyFromNumRequest value) {
        return new JAXBElement<ModifyFromNumRequest>(_ModifyFromNumRequest_QNAME, ModifyFromNumRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyVoiceMailPinRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:zimbraVoice", name = "ModifyVoiceMailPinRequest")
    public JAXBElement<ModifyVoiceMailPinRequest> createModifyVoiceMailPinRequest(ModifyVoiceMailPinRequest value) {
        return new JAXBElement<ModifyVoiceMailPinRequest>(_ModifyVoiceMailPinRequest_QNAME, ModifyVoiceMailPinRequest.class, null, value);
    }

}
