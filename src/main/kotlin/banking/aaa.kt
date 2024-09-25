package banking

fun getRoomDB(
    builder: RoomDB.Builder<AppDB>
): AppDB {
    return builder.setDriver(BundledSQLiteDriver())
}