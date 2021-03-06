package model

data class StructureDataModel(
		val analysis: String,
		val nodes: List<NodeData>,
		val materials: List<MaterialData>,
		val sections: List<SectionData>,
		val distributedLoads: List<DistributedLoad>,
		val elements: List<ElementData>
) {
	
	data class NodeData(
			val id: Int,
			val x: Double,
			val y: Double,
			val z: Double,
			val suppCond: Array<String>,
			val loadValues: DoubleArray,
			val stiffValues: DoubleArray
	) {
		override fun equals(other: Any?): Boolean {
			if (this === other) return true
			if (javaClass != other?.javaClass) return false
			
			other as NodeData
			
			if (id != other.id) return false
			
			return true
		}
		
		override fun hashCode(): Int {
			return id
		}
	}
	
	data class MaterialData(
			val id: Int,
			val longElastModulus: Double,
			val poissonRatio: Double,
			val transElastModulus: Double
	)
	
	data class SectionData(
			val id: Int,
			val area: Double,
			val inertiaMomentZ: Double,
			val inertiaMomentY: Double
	)
	
	data class DistributedLoad(
			val id: Int,
			val qxi: Double,
			val qxj: Double,
			val qyi: Double,
			val qyj: Double,
			val isLocalLoad: Boolean
	)
	
	data class ElementData(
			val id: Int,
			val nodeId1: Int,
			val nodeId2: Int,
			val materialId: Int,
			val sectionId: Int,
			val hasHingedBegin: Boolean,
			val hasHingedEnd: Boolean,
			val loadId: Int
	)
}