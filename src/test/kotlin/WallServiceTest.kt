import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val post = service.add(Post(1,10,11,200,300,"First post",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link1","name1","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Ivanov",true,"edit"),8))

        val result = post.id
        //assertNotEquals(0, result)
        assertEquals(1, result)

    }

    @Test
    fun updateExisting() {
        val service = WallService()
        service.add(Post(1,10,11,200,300,"First post",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link1","name1","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Ivanov",true,"edit"),8))
        service.add(Post(5,10,11,200,300,"Second post",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link1","name1","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Petrov",true,"edit"),8))
        service.add(Post(8,10,11,200,300,"Some post",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link1","name1","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Sidorov",true,"edit"),8))

        val update = Post(2,10,11,200,300,"Second post updated",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link2","name3","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Petrov",true,"edit"),8)

        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService()
        service.add(Post(1,10,11,200,300,"First post",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link1","name1","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Ivanov",true,"edit"),8))
        service.add(Post(5,10,11,200,300,"Second post",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link1","name1","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Petrov",true,"edit"),8))
        service.add(Post(8,10,11,200,300,"Some post",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link1","name1","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Sidorov",true,"edit"),8))

        val update = Post(21,10,11,200,300,"Second post updated",4,5,
            false, Comments(3,true,true,true,true),
            Copyright(1,"link2","name3","type1"), Likes(321,true,true,true),
            Reposts(8,true),Views(220),"post",300,true,true,
            false,false,false,true,Donut(true,500,
                "Petrov",true,"edit"),8)

        val result = service.update(update)
        assertFalse(result)
    }
}