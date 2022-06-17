package com.example.compose.jetsurvey.survey

import android.os.Build
import com.example.compose.jetsurvey.R
import com.example.compose.jetsurvey.survey.PossibleAnswer.Action
import com.example.compose.jetsurvey.survey.PossibleAnswer.MultipleChoice
import com.example.compose.jetsurvey.survey.PossibleAnswer.SingleChoice
import com.example.compose.jetsurvey.survey.SurveyActionType.PICK_DATE
import com.example.compose.jetsurvey.survey.SurveyActionType.TAKE_PHOTO

// Static data of questions
private val jetpackQuestions = mutableListOf(
    /*Question(
        id = 1,
        questionText = R.string.como_te_has_sentido_ultimamente,
        answer = MultipleChoice(
            optionsStringRes = listOf(
                R.string.muy_bien,
                R.string.work_out,
                R.string.draw,
                R.string.play_games,
                R.string.dance,
                R.string.watch_movies
            )
        ),
        description = R.string.select_all
    ),*/

    /*Question(
        id = 2,
        questionText = R.string.pick_superhero,
        answer = PossibleAnswer.SingleChoiceIcon(
            optionsStringIconRes = listOf(
                Pair(R.drawable., R.string.spark),
                Pair(R.drawable.lenz, R.string.lenz),
                Pair(R.drawable.bug_of_chaos, R.string.bugchaos),
                Pair(R.drawable.frag, R.string.frag)
            )
        ),
        description = R.string.select_one
    ),*/

    Question(
        id = 1,
        questionText = R.string.Tos,
        answer = SingleChoice(
            listOf(
                R.string.Si,
                R.string.No,
                R.string.Nose
            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 2,
        questionText = R.string.garganta,
        answer = SingleChoice(
            listOf(
                R.string.Si,
                R.string.No,
                R.string.tal_vez

            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 3,
        questionText = R.string.congestion,
        answer = SingleChoice(
            listOf(
                R.string.Si2,
                R.string.No2,
                R.string.Nose1

            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 4,
        questionText = R.string.pecho,
        answer = SingleChoice(
            listOf(
                R.string.si3,
                R.string.No3

            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 5,
        questionText = R.string.Agotado,
        answer = SingleChoice(
            listOf(
                R.string.Si4,
                R.string.No4,
                R.string.Talvez1
            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 6,
        questionText = R.string.Silbido,
        answer = SingleChoice(
            listOf(
                R.string.Si5,
                R.string.No5,
                R.string.Talvez2
            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 7,
        questionText = R.string.Dormir,
        answer = SingleChoice(
            listOf(
                R.string.Si6,
                R.string.No6
            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 8,
        questionText = R.string.Ronquera,
        answer = SingleChoice(
            listOf(
                R.string.Si7,
                R.string.No7,
                R.string.Talvez3
            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 9,
        questionText = R.string.Fiebre,
        answer = SingleChoice(
            listOf(
                R.string.Si8,
                R.string.No8
            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 10,
        questionText = R.string.Olfato,
        answer = SingleChoice(
            listOf(
                R.string.Si9,
                R.string.No9
            )
        ),
        description = R.string.select_one
    ),
    Question(
        id = 11,
        questionText = R.string.Comer,
        answer = SingleChoice(
            listOf(
                R.string.Si10,
                R.string.No10
            )
        ),
        description = R.string.select_one
    ),

    Question(
        id = 12,
        questionText = R.string.takeaway,
        answer = Action(label = R.string.pick_date, actionType = PICK_DATE),
        description = R.string.select_date
    ),

    Question(
        id = 13,
        questionText = R.string.selfies,
        answer = PossibleAnswer.Slider(
            range = 1f..10f,
            steps = 3,
            startText = R.string.mal,
            endText = R.string.bien,
            neutralText = R.string.normal
        )
    ),
).apply {
    // TODO: FIX! After taking the selfie, the picture doesn't appear in API 22 and lower.
    if (Build.VERSION.SDK_INT >= 23) {
        /*add(

            Question(
                id = 975,
                questionText = R.string.selfie_skills,
                answer = Action(label = R.string.add_photo, actionType = TAKE_PHOTO),
                permissionsRequired =
                when (Build.VERSION.SDK_INT) {
                    in 23..28 -> listOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    else -> emptyList()
                },
                permissionsRationaleText = R.string.selfie_permissions
            )
        )*/
    }
}.toList()

private val jetpackSurvey = Survey(
    title = R.string.which_jetpack_library,
    questions = jetpackQuestions
)

object JetpackSurveyRepository : SurveyRepository {

    override fun getSurvey() = jetpackSurvey

    @Suppress("UNUSED_PARAMETER")
    override fun getSurveyResult(answers: List<Answer<*>>): SurveyResult {
        return SurveyResult(
            library = "Mejorate!!!",
            result = R.string.survey_result,
            description = R.string.survey_result_description
        )
    }
}

interface SurveyRepository {
    fun getSurvey(): Survey

    fun getSurveyResult(answers: List<Answer<*>>): SurveyResult
}
