package urbanistic.clipper
import kotlin.test.Test

import kotlin.test.assertEquals

public class Test {

    @Test
    fun simpleUnionTest(){
        val subj = Paths()
        subj.add (Path())
        subj[0].add(LongPoint(180, 200))
        subj[0].add(LongPoint(260, 200))
        subj[0].add(LongPoint(260, 150))
        subj[0].add(LongPoint(180, 150))

        subj.add(Path())
        subj[1].add(LongPoint(215, 160))
        subj[1].add(LongPoint(230, 190))
        subj[1].add(LongPoint(200, 190))

        val clip = Paths()
        clip.add(Path())
        clip[0].add(LongPoint(190, 210))
        clip[0].add(LongPoint(240, 210))
        clip[0].add(LongPoint(240, 130))
        clip[0].add(LongPoint(190, 130))

        val solution = Paths();

        val c = Clipper()
        c.addPaths(subj, PolyType.Subject, true);
        c.addPaths(clip, PolyType.Clip, true);
        c.execute(
            ClipType.Intersection, solution,
            PolyFillType.EvenOdd, PolyFillType.EvenOdd)

        assertEquals(2, solution.size)
    }


}