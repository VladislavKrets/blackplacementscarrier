package online.omnia.carrier;

/**
 * Created by lollipop on 15.02.2018.
 */
public class CampaignRule {
    private int id;
    private String type;
    private Integer campaignId;
    private Integer deviceOsId;
    private String deviceOsVersionId;
    private Integer deviceMakeId;
    private Integer deviceModelId;
    private Integer carrierId;
    private Integer placementId;
    private Integer carrierIspId;
    private Integer exchangeId;

    public Integer getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(Integer deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getDeviceOsId() {
        return deviceOsId;
    }

    public void setDeviceOsId(Integer deviceOsId) {
        this.deviceOsId = deviceOsId;
    }

    public String getDeviceOsVersionId() {
        return deviceOsVersionId;
    }

    public void setDeviceOsVersionId(String deviceOsVersionId) {
        this.deviceOsVersionId = deviceOsVersionId;
    }

    public Integer getDeviceMakeId() {
        return deviceMakeId;
    }

    public void setDeviceMakeId(Integer deviceMakeId) {
        this.deviceMakeId = deviceMakeId;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

    public Integer getCarrierIspId() {
        return carrierIspId;
    }

    public void setCarrierIspId(Integer carrierIspId) {
        this.carrierIspId = carrierIspId;
    }

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }
}
