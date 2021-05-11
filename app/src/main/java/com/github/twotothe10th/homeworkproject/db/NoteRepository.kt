package com.github.twotothe10th.homeworkproject.db

import kotlin.collections.ArrayList

class NoteRepository {

    interface UpdateListener {
        fun setNoteList(noteList: List<Note>)
    }

    private val subscribersOnUpdate = ArrayList<UpdateListener>()
    private val noteDict: MutableMap<Long, Note> = mutableMapOf()
    private val defaultNoteList = listOf(
        NoteDao.NoteToInsert(
            "Aerondight is a silver sword used in fighting monsters, and is relatively ineffective against humans. It can be received only in Chapter IV and can neither be bought nor sold. In The Paths of Destiny, according to a quest phase titled \"The Sword\", the blade is exceptional: \"light, sharp as a razor, and fits the hand neatly\". In the same entry, it is said that the blade \"has a destiny of its own. Time will tell what that destiny is\". Lady of the Lake knights Geralt after he fulfills her wishes, and gives him this blade along with the words: \"Take this sword as a sign of my favor. Once the blade of a great warrior, it lay in the depths for ages, awaiting your arrival.\"",
            "2020-04-01",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/aerondight"
        ),
        NoteDao.NoteToInsert(
            "Ami переводится с французского как друг.\n" +
                    "Этот меч имеет схожий внешний вид со Стальным мечом из Махакама и выполнен в традиционном краснолюдском стиле изготовления клинков.",
            "2020-04-02",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/ami"
        ),
        NoteDao.NoteToInsert(
            "Анафема, или Серебряный меч Святотатца\n" +
                    "В бою этот меч «пьет» жизненную силу врагов, одновременно укрепляя здоровье своего хозяина, однако наносит урон собственному владельцу, если тот носит его вне комплекта.",
            "2020-04-03",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/anafema"
        ),
        NoteDao.NoteToInsert(
            "Бельхавенский клинок\n" +
                    "Этот меч нельзя найти или получить. Его можно только изготовить у кузнеца по соответствующему чертежу, который находится в одном из сундуков на юге Туссента.\n" +
                    "Этот клинок имеет оголовок, характерный для мечей Школы Змеи.\n",
            "2020-04-04",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/belhaven_blade"
        ),
        NoteDao.NoteToInsert(
            "Блёд Аэдд\n" +
                    "Геральт может взять этот меч с останков Сарасти в ходе квеста «Заказ: Тайна деревни Стёжки» или найти в ходе странствий.",
            "2020-04-05",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/bloed_aedd"
        ),
        NoteDao.NoteToInsert(
            "Блеф\n" +
                    "Геральт может получить этот меч, если во время гвинт-турнира в ходе квеста «Гвинт: Большой турнир в Боклере» согласится поставить свой серебряный меч против меча Хамаля аль Данбали и выиграет партию.\n" +
                    "Имеет уникальное навершие в виде лилии с тремя камнями.",
            "2020-04-06",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/blave"
        ),
        NoteDao.NoteToInsert(
            "Веленский длинный меч\n" +
                    "Существует 3 вариации этого оружия. Геральт может найти две из них в ходе странствий или купить у различных торговцев. Последнюю он может только сделать с помощью кузнеца по соответствующему чертежу.\n" +
                    "Этот меч имеет идентичный внешний вид с Ведьмачьим стальным мечом.\n",
            "2020-04-07",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/velen_longsword"
        ),
        NoteDao.NoteToInsert(
            "Вершитель Судеб\n" +
                    "Существует 2 вариации этого меча. Геральт может найти одну из них в ходе странствий. Другую он может только сделать с помощью кузнеца по соответствующему чертежу.\n",
            "2020-04-08",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/arbitrator"
        ),
        NoteDao.NoteToInsert(
            "Гвихир\n" +
                    "Гвихиры по праву считаются лучшими мечами в мире и когда-то изготавливались под горным массивом Тир Тохаир. Гномы ковали свои мечи из традиционной темной стали, покрывали лезвия ажуром, чтобы уменьшить их вес, а также по-особому затачивали их в пламени по совершенной технологии невероятно остро. Рукояти гвихиров обычно выполнялись из кожи скатов, а поэтому они не скользили, даже если между ними и рукой был пот или кровь. К концу XIII века гвихиры крайне редки и стоят баснословных денег.\n" +
                    "Меч Цири, Ласточка, являлся гвихиром.\n" +
                    "Геральт может случайным образом найти этот меч в ходе своих странствий, например, в Велене в ходе квеста «Заказ: Пропавший брат».",
            "2020-04-09",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/gwyhyr"
        ),
        NoteDao.NoteToInsert(
            "Гвестог\n" +
                    "Геральт может найти этот меч в ходе странствий, например на останках командира охотника за колдуньями в ходе квеста «Сейчас или никогда» или получить в награду после квеста «Кулаки ярости: Скеллиге».",
            "2020-04-10",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/gwestog"
        ),
        NoteDao.NoteToInsert(
            "Гвен'нель\n" +
                    "Существует 4 вариации этого меча. Геральт может найти три из них в ходе странствий или купить у различных торговцев. Последнюю он может только сделать с помощью кузнеца используя соответствующий чертеж.",
            "2020-04-11",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/gvennel"
        ),
        NoteDao.NoteToInsert(
            "Гав'кар\n" +
                    "Геральт получает этот меч после победы над Эредином.",
            "2020-04-12",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/havcaaren"
        ),
        NoteDao.NoteToInsert(
            "Луна\n" +
                    "Геральт может найти этот меч в ходе странствий.\n",
            "2020-04-13",
            "android.resource://com.github.twotothe10th.homeworkproject/drawable/lune"
        )
    )
    private var noteDao: NoteDao? = null

    fun setDatabase(db: AppDatabase) {
        noteDao = db.noteDao()

        if (noteDao!!.IsEmpty()) {
            for (note in defaultNoteList) {
                insertNote(note.description, note.date, note.imageUri)
            }
        }

        noteDao!!.getAll().map { note -> noteDict[note.id] = note }
        onUpdate()
    }

    private val noteList: List<Note>
        get() = noteDict.values.toList()

    fun addUpdateListener(updateListener: UpdateListener) {
        subscribersOnUpdate.add(updateListener)
        updateListener.setNoteList(noteList)
    }

    fun removeUpdateListener(updateListener: UpdateListener) {
        subscribersOnUpdate.remove(updateListener)
    }

    private fun onUpdate() {
        for (subscriber in subscribersOnUpdate) {
            subscriber.setNoteList(noteList)
        }
    }

    private fun insertNote(description: String, date: String, imageUri: String) {
        val newNote = noteDao!!.insert(description, date, imageUri)
        noteDict[newNote.id] = newNote
    }

    fun get(id: Long) = noteDict[id]
}