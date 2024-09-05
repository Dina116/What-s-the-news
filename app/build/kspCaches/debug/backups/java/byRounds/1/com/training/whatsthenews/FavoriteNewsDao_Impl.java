package com.training.whatsthenews;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteNewsDao_Impl implements FavoriteNewsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavoriteNewsEntity> __insertionAdapterOfFavoriteNewsEntity;

  private final EntityDeletionOrUpdateAdapter<FavoriteNewsEntity> __deletionAdapterOfFavoriteNewsEntity;

  public FavoriteNewsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavoriteNewsEntity = new EntityInsertionAdapter<FavoriteNewsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favorite_news` (`title`,`uniformResourceLocator`,`urlToImage`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteNewsEntity entity) {
        statement.bindString(1, entity.getTitle());
        statement.bindString(2, entity.getUniformResourceLocator());
        statement.bindString(3, entity.getUrlToImage());
      }
    };
    this.__deletionAdapterOfFavoriteNewsEntity = new EntityDeletionOrUpdateAdapter<FavoriteNewsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `favorite_news` WHERE `title` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteNewsEntity entity) {
        statement.bindString(1, entity.getTitle());
      }
    };
  }

  @Override
  public Object insertFavoriteNews(final List<FavoriteNewsEntity> favoriteNews,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavoriteNewsEntity.insert(favoriteNews);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFavoriteNews(final List<FavoriteNewsEntity> favoriteNews,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavoriteNewsEntity.handleMultiple(favoriteNews);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<FavoriteNewsEntity>> getFavoriteNews() {
    final String _sql = "SELECT * FROM favorite_news";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"favorite_news"}, false, new Callable<List<FavoriteNewsEntity>>() {
      @Override
      @Nullable
      public List<FavoriteNewsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUniformResourceLocator = CursorUtil.getColumnIndexOrThrow(_cursor, "uniformResourceLocator");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final List<FavoriteNewsEntity> _result = new ArrayList<FavoriteNewsEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FavoriteNewsEntity _item;
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUniformResourceLocator;
            _tmpUniformResourceLocator = _cursor.getString(_cursorIndexOfUniformResourceLocator);
            final String _tmpUrlToImage;
            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            _item = new FavoriteNewsEntity(_tmpTitle,_tmpUniformResourceLocator,_tmpUrlToImage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
