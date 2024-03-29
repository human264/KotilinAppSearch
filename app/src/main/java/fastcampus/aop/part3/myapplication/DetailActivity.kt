package fastcampus.aop.part3.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.bumptech.glide.Glide
import fastcampus.aop.part3.aop_part3_chapter04.model.Book
import fastcampus.aop.part3.myapplication.databinding.ActivityDetailBinding
import fastcampus.aop.part3.myapplication.model.Review

class DetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var db:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "historyDB").build()

        val model = intent.getParcelableExtra<Book>("bookModel")

        binding.titleTextView.text = model?.title.orEmpty()

        Glide.with(binding.coverImageView.context)
            .load(model?.coverSmallUrl.orEmpty())
            .into(binding.coverImageView)

        binding.descriptionTextView.text = model?.description.orEmpty()

        Thread {
            val review = db.reviewDao().getOneReview(model?.id?.toInt() ?: 0)
            runOnUiThread{
                binding.reviewEditText.setText(review?.review.orEmpty())
            }
        }.start()


        binding.saveButton.setOnClickListener{
            Thread {
                db.reviewDao().saveReview(
                    Review(
                        model?.id?.toInt()?: 0,
                        binding.reviewEditText.text.toString()
                    )
                )
            }.start()
        }


    }
}