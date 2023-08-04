import androidx.room.Embedded
import androidx.room.Relation
import com.example.hirein.data.DB.entity.JobPost
import com.example.hirein.data.DB.entity.Tag

data class JobPostWithTags(
    @Embedded val jobPost: JobPost,
    @Relation(
        parentColumn = "jobPostId",
        entityColumn = "jobPostId"
    )
    val tags: List<Tag>
)