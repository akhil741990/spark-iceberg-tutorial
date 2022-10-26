package org.soul.iceberg.spark;

import org.apache.iceberg.Table;
import org.apache.iceberg.catalog.Catalog;
import org.apache.iceberg.hive.HiveCatalog;
import org.apache.spark.sql.SparkSession;
import org.apache.iceberg.spark.SparkSessionCatalog;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkSession spark = SparkSession.builder().master("local[2]")
				.config("spark.sql.extensions","org.apache.iceberg.spark.extensions.IcebergSparkSessionExtensions")
				.config("spark.sql.catalog.spark_catalog","org.apache.iceberg.spark.SparkSessionCatalog")
				.config("spark.sql.catalog.spark_catalog.type","hive")
				.config("spark.sql.catalog.local","org.apache.iceberg.spark.SparkCatalog")
				.config("spark.sql.catalog.local.type","hadoop")
				.config("spark.sql.catalog.local.warehouse","/iceberg/warehouse")
				.getOrCreate();
		
	

		spark.close();
		
	}

}
