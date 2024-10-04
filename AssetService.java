/**
 * Service to find Assets matching predicates and set their groupings.
 */
@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    /**
     * Gets all predicates, evaluates which Assets fulfill them all, removes duplicates and sets group_name on those Assets.
     */
    public void applyGroupingRules(List<DependentAssetPredicate> predicates, String group_name) {
        predicates
            .stream()
            .map(p -> {
                findAssetsWithDependentPredicates(p.getPredicates());
            })
            .filter(/* remove duplicates */)
            .map(asset -> asset.setGroupName(group_name));
    }

    /**
     * Delegates to the database and queries for all assets fulfilling the given {@link AssetPredicate}s.
     */
    public List<Asset> findAssetsWithDependentPredicates(List<AssetPredicate> predicates) {
        AssetSpecification specification = new AssetSpecification();

        // map predicates to queries by doing conditionals on fieldName and value specifications
        
        // Fetching assets that match the predicates
        return assetRepository.findAll(specifications);
    }
}