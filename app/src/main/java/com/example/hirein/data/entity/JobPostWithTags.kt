import androidx.room.Embedded
import androidx.room.Relation
import com.example.hirein.data.entity.JobPost
import com.example.hirein.data.entity.Tag

data class JobPostWithTags(
    @Embedded val jobPost: JobPost,
    @Relation(
        parentColumn = "jobPostId",
        entityColumn = "jobPostId"
    )
    val tags: List<Tag>
)