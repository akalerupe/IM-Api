import javax.persistence.*

@Entity
@Table(name="institution")

data class Institution(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        val name:String,
        val location:String,
        val population:Int,
        )