package com.github.twotothe10th.homeworkproject.db

import kotlinx.coroutines.*
import kotlin.collections.ArrayList

class NoteRepository {

    interface UpdateListener {
        suspend fun setNoteList(noteList: List<Note>)
    }

    private val subscribersOnUpdate = ArrayList<UpdateListener>()
    private val noteDict: MutableMap<Long, Note> = mutableMapOf()
    private val defaultNoteList = listOf(
        NoteDao.NoteToInsert(
            "Aerondight is a silver sword used in fighting monsters, and is relatively ineffective against humans. It can be received only in Chapter IV and can neither be bought nor sold. In The Paths of Destiny, according to a quest phase titled \"The Sword\", the blade is exceptional: \"light, sharp as a razor, and fits the hand neatly\". In the same entry, it is said that the blade \"has a destiny of its own. Time will tell what that destiny is\". Lady of the Lake knights Geralt after he fulfills her wishes, and gives him this blade along with the words: \"Take this sword as a sign of my favor. Once the blade of a great warrior, it lay in the depths for ages, awaiting your arrival.\"",
            1620769064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/aerondight"
        ),
        NoteDao.NoteToInsert(
            "Ami переводится с французского как друг.\n" +
                    "Этот меч имеет схожий внешний вид со Стальным мечом из Махакама и выполнен в традиционном краснолюдском стиле изготовления клинков.",
            1620779064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/ami"
        ),
        NoteDao.NoteToInsert(
            "Анафема, или Серебряный меч Святотатца\n" +
                    "В бою этот меч «пьет» жизненную силу врагов, одновременно укрепляя здоровье своего хозяина, однако наносит урон собственному владельцу, если тот носит его вне комплекта.",
            1620789064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/anafema"
        ),
        NoteDao.NoteToInsert(
            "Бельхавенский клинок\n" +
                    "Этот меч нельзя найти или получить. Его можно только изготовить у кузнеца по соответствующему чертежу, который находится в одном из сундуков на юге Туссента.\n" +
                    "Этот клинок имеет оголовок, характерный для мечей Школы Змеи.\n",
            1620799064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/belhaven_blade"
        ),
        NoteDao.NoteToInsert(
            "Блёд Аэдд\n" +
                    "Геральт может взять этот меч с останков Сарасти в ходе квеста «Заказ: Тайна деревни Стёжки» или найти в ходе странствий.",
            1620809064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/bloed_aedd"
        ),
        NoteDao.NoteToInsert(
            "Блеф\n" +
                    "Геральт может получить этот меч, если во время гвинт-турнира в ходе квеста «Гвинт: Большой турнир в Боклере» согласится поставить свой серебряный меч против меча Хамаля аль Данбали и выиграет партию.\n" +
                    "Имеет уникальное навершие в виде лилии с тремя камнями.",
            1620819064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/blave"
        ),
        NoteDao.NoteToInsert(
            "Веленский длинный меч\n" +
                    "Существует 3 вариации этого оружия. Геральт может найти две из них в ходе странствий или купить у различных торговцев. Последнюю он может только сделать с помощью кузнеца по соответствующему чертежу.\n" +
                    "Этот меч имеет идентичный внешний вид с Ведьмачьим стальным мечом.\n",
            1620869064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/velen_longsword"
        ),
        NoteDao.NoteToInsert(
            "Вершитель Судеб\n" +
                    "Существует 2 вариации этого меча. Геральт может найти одну из них в ходе странствий. Другую он может только сделать с помощью кузнеца по соответствующему чертежу.\n",
            1620969064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/arbitrator"
        ),
        NoteDao.NoteToInsert(
            "Гвихир\n" +
                    "Гвихиры по праву считаются лучшими мечами в мире и когда-то изготавливались под горным массивом Тир Тохаир. Гномы ковали свои мечи из традиционной темной стали, покрывали лезвия ажуром, чтобы уменьшить их вес, а также по-особому затачивали их в пламени по совершенной технологии невероятно остро. Рукояти гвихиров обычно выполнялись из кожи скатов, а поэтому они не скользили, даже если между ними и рукой был пот или кровь. К концу XIII века гвихиры крайне редки и стоят баснословных денег.\n" +
                    "Меч Цири, Ласточка, являлся гвихиром.\n" +
                    "Геральт может случайным образом найти этот меч в ходе своих странствий, например, в Велене в ходе квеста «Заказ: Пропавший брат».",
            1621069064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/gwyhyr"
        ),
        NoteDao.NoteToInsert(
            "Гвестог\n" +
                    "Геральт может найти этот меч в ходе странствий, например на останках командира охотника за колдуньями в ходе квеста «Сейчас или никогда» или получить в награду после квеста «Кулаки ярости: Скеллиге».",
            1621269064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/gwestog"
        ),
        NoteDao.NoteToInsert(
            "Гвен'нель\n" +
                    "Существует 4 вариации этого меча. Геральт может найти три из них в ходе странствий или купить у различных торговцев. Последнюю он может только сделать с помощью кузнеца используя соответствующий чертеж.",
            1621469064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/gvennel"
        ),
        NoteDao.NoteToInsert(
            "Гав'кар\n" +
                    "Геральт получает этот меч после победы над Эредином.",
            1621669064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/havcaaren"
        ),
        NoteDao.NoteToInsert(
            "Луна\n" +
                    "Геральт может найти этот меч в ходе странствий.\n",
            1621869064000,
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/lune"
        )
    )
    private var noteDao: NoteDao? = null
    private val coroutineScope = MainScope() + CoroutineName("NoteRepositoryCoroutine")
    private val noteList: List<Note>
        get() = noteDict.values.toList()

    fun setDatabase(db: AppDatabase) {

        coroutineScope.launch {
            noteDict.clear()
            noteDao = db.noteDao()

            withContext(Dispatchers.IO) {
                if (noteDao!!.IsEmpty()) {
                    for (note in defaultNoteList) {
                        justInsertNote(note.description, note.date, note.imageUri)
                    }
                }
                noteDao!!.getAll()
            }.map { note -> noteDict[note.id] = note }

            onUpdate()
        }
    }

    fun addUpdateListener(updateListener: UpdateListener) {
        coroutineScope.launch {
            subscribersOnUpdate.add(updateListener)
            updateListener.setNoteList(noteList)
        }
    }

    fun removeUpdateListener(updateListener: UpdateListener) {
        subscribersOnUpdate.remove(updateListener)
    }

    fun get(id: Long) = noteDict[id]

    suspend fun insertNote(description: String, date: Long, imageUri: String): Long {
        val newId = justInsertNote(description, date, imageUri)
        onUpdate()
        return newId
    }

    private suspend fun onUpdate() {
        val cachedNoteList = noteList
        for (subscriber in subscribersOnUpdate) {
            subscriber.setNoteList(cachedNoteList)
        }
    }

    private suspend fun justInsertNote(description: String, date: Long, imageUri: String): Long {
        val newNote = withContext(Dispatchers.IO) { noteDao!!.insert(description, date, imageUri) }
        noteDict[newNote.id] = newNote
        return newNote.id
    }
}