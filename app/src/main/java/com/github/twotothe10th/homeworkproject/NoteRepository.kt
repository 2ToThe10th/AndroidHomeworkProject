package com.github.twotothe10th.homeworkproject

import android.net.Uri

class NoteRepository {
    companion object {
        private const val tag = "NoteRepository"
    }

    val noteList =
        listOf(
            Note(
                0,
                "Aerondight is a silver sword used in fighting monsters, and is relatively ineffective against humans. It can be received only in Chapter IV and can neither be bought nor sold. In The Paths of Destiny, according to a quest phase titled \"The Sword\", the blade is exceptional: \"light, sharp as a razor, and fits the hand neatly\". In the same entry, it is said that the blade \"has a destiny of its own. Time will tell what that destiny is\". Lady of the Lake knights Geralt after he fulfills her wishes, and gives him this blade along with the words: \"Take this sword as a sign of my favor. Once the blade of a great warrior, it lay in the depths for ages, awaiting your arrival.\"",
                "2020-04-01",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/aerondight")
            ),
            Note(
                1,
                "Ami переводится с французского как друг.\n" +
                        "Этот меч имеет схожий внешний вид со Стальным мечом из Махакама и выполнен в традиционном краснолюдском стиле изготовления клинков.",
                "2020-04-02",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/ami")
            ),
            Note(
                2,
                "Анафема, или Серебряный меч Святотатца\n" +
                        "В бою этот меч «пьет» жизненную силу врагов, одновременно укрепляя здоровье своего хозяина, однако наносит урон собственному владельцу, если тот носит его вне комплекта.",
                "2020-04-03",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/anafema")
            ),
            Note(
                3,
                "Бельхавенский клинок\n" +
                        "Этот меч нельзя найти или получить. Его можно только изготовить у кузнеца по соответствующему чертежу, который находится в одном из сундуков на юге Туссента.\n" +
                        "Этот клинок имеет оголовок, характерный для мечей Школы Змеи.\n",
                "2020-04-04",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/belhaven_blade")
            ),
            Note(
                4,
                "Блёд Аэдд\n" +
                        "Геральт может взять этот меч с останков Сарасти в ходе квеста «Заказ: Тайна деревни Стёжки» или найти в ходе странствий.",
                "2020-04-05",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/bloed_aedd")
            ),
            Note(
                5,
                "Блеф\n" +
                        "Геральт может получить этот меч, если во время гвинт-турнира в ходе квеста «Гвинт: Большой турнир в Боклере» согласится поставить свой серебряный меч против меча Хамаля аль Данбали и выиграет партию.\n" +
                        "Имеет уникальное навершие в виде лилии с тремя камнями.",
                "2020-04-06",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/blave")
            ),
            Note(
                6,
                "Веленский длинный меч\n" +
                        "Существует 3 вариации этого оружия. Геральт может найти две из них в ходе странствий или купить у различных торговцев. Последнюю он может только сделать с помощью кузнеца по соответствующему чертежу.\n" +
                        "Этот меч имеет идентичный внешний вид с Ведьмачьим стальным мечом.\n",
                "2020-04-07",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/velen_longsword")
            ),
            Note(
                7,
                "Вершитель Судеб\n" +
                        "Существует 2 вариации этого меча. Геральт может найти одну из них в ходе странствий. Другую он может только сделать с помощью кузнеца по соответствующему чертежу.\n",
                "2020-04-08",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/arbitrator")
            ),
            Note(
                8,
                "Гвихир\n" +
                        "Гвихиры по праву считаются лучшими мечами в мире и когда-то изготавливались под горным массивом Тир Тохаир. Гномы ковали свои мечи из традиционной темной стали, покрывали лезвия ажуром, чтобы уменьшить их вес, а также по-особому затачивали их в пламени по совершенной технологии невероятно остро. Рукояти гвихиров обычно выполнялись из кожи скатов, а поэтому они не скользили, даже если между ними и рукой был пот или кровь. К концу XIII века гвихиры крайне редки и стоят баснословных денег.\n" +
                        "Меч Цири, Ласточка, являлся гвихиром.\n" +
                        "Геральт может случайным образом найти этот меч в ходе своих странствий, например, в Велене в ходе квеста «Заказ: Пропавший брат».",
                "2020-04-09",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/gwyhyr")
            ),
            Note(
                9,
                "Гвестог\n" +
                        "Геральт может найти этот меч в ходе странствий, например на останках командира охотника за колдуньями в ходе квеста «Сейчас или никогда» или получить в награду после квеста «Кулаки ярости: Скеллиге».",
                "2020-04-10",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/gwestog")
            ),
            Note(
                10,
                "Гвен'нель\n" +
                        "Существует 4 вариации этого меча. Геральт может найти три из них в ходе странствий или купить у различных торговцев. Последнюю он может только сделать с помощью кузнеца используя соответствующий чертеж.",
                "2020-04-11",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/gvennel")
            ),
            Note(
                11,
                "Гав'кар\n" +
                        "Геральт получает этот меч после победы над Эредином.",
                "2020-04-12",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/havcaaren")
            ),
            Note(
                12,
                "Луна\n" +
                        "Геральт может найти этот меч в ходе странствий.\n",
                "2020-04-13",
                Uri.parse("android.resource://com.github.twotothe10th.homeworkproject/drawable/lune")
            )
        )

    fun get(id: Int): Note? {
        return noteList[id]
    }
}