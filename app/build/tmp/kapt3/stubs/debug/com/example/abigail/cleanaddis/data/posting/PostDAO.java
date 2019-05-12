package com.example.abigail.cleanaddis.data.posting;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/abigail/cleanaddis/data/posting/PostDAO;", "", "deleteAll", "", "deletePost", "post", "Lcom/example/abigail/cleanaddis/entity/posting/Post;", "getPostByUUID", "uuid", "Ljava/util/UUID;", "insertPost", "updatePost", "app_debug"})
public abstract interface PostDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM post WHERE post_uuid =:uuid")
    public abstract com.example.abigail.cleanaddis.entity.posting.Post getPostByUUID(@org.jetbrains.annotations.NotNull()
    java.util.UUID uuid);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertPost(@org.jetbrains.annotations.NotNull()
    com.example.abigail.cleanaddis.entity.posting.Post post);
    
    @androidx.room.Update()
    public abstract void updatePost(@org.jetbrains.annotations.NotNull()
    com.example.abigail.cleanaddis.entity.posting.Post post);
    
    @androidx.room.Delete()
    public abstract void deletePost(@org.jetbrains.annotations.NotNull()
    com.example.abigail.cleanaddis.entity.posting.Post post);
    
    @androidx.room.Query(value = "DELETE FROM post")
    public abstract void deleteAll();
}