/**
 * API that allows getting and manipulating Assets, including grouping them. 
 */
@RequestMapping("/api/asset")
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;


    /**
     * Method to set field group_name on any Assets fulfilling the given predicates.
     * 
     * Delegates to AssetService.
     */
    // TODO this could be generified to set any field to any value based on some predicates
    @PostMapping("/addAssetsToGroup")
    public List<Asset> groupAssets(@RequestBody GroupAssetRequest request) {
        List<DependentAssetPredicate> predicates = request.getPredicates();
        String group_name = request.getGroupName();
        // delegates to AssetService to query the database and update the assets
        return AssetService.applyGroupingRules(predicates, group_name);
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        // Fetch all assets from the repository
        return assetRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable String id) {
        return Optional.ofassetRepository.findById(id))
            .map(ResponseEntity.ok(asset.get()))
            .orElseGet(() -> ResponseEntity.notFound());
    }

    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        // Save the asset to the database
        Asset savedAsset = assetRepository.save(asset);
        return ResponseEntity.ok(savedAsset);
    }

    // supports editing values of asset
    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable String id, @RequestBody Asset updatedAsset) {
        // ...
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable String id) {
        // Delete asset by ID if it exists
        if (assetRepository.existsById(id)) {
            assetRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}