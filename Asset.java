/**
 * POJO to represent an asset.
 */
public class Asset {
    private String id;

    private String name;

    private String type;

    private CloudAccount cloud_account;

    // alternatively could use the Tag POJO class
    private Map<String, String> tags;

    private String owner_id;

    private String region;

    // TODO: we are populating this value per asset
    private String group_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CloudAccount getCloudAccount() {
        return cloud_account;
    }

    public void setCloudAccount(CloudAccount cloud_account) {
        this.cloud_account = cloud_account;
    }

    public Map<String, String> getTags() {
        if (tags == null) {
            return new HashMap<>();
        }
        return tags;
    }

    public String getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGroupName() {
        return group_name;
    }

    public void setGroupName(String group_name) {
        this.group_name = group_name;
    }
}