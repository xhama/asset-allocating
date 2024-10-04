/**
 * Represents a request for that uses predicates to qualify and search Assets.
 * 
 * Encapsulates group_name to give Assets.
 * 
 * TODO could be generified to set any value on any field by changing group_name to value and adding a field variable to this class.
 */
public class GroupAssetRequest {

    private List<DependentAssetPredicate> predicates;

    private String group_name;

    // getters and setters
    public List<DependentAssetPredicate> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<DependentAssetPredicate> predicates) {
        this.predicates = predicates;
    }

    public String getGroupName() {
        return group_name;
    }

    public void setGroupName(String groupName) {
        this.group_name = groupName;
    }
}