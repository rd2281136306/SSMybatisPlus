package com.pinyougou.util;


import com.pinyougou.constant.CommonParam;
import com.pinyougou.constant.ResponseBasic;
import com.pinyougou.enums.ErrorEnum;
import com.pinyougou.exception.org.ORGException;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author:  
 * 描述: redis工具类
 * @date: 
 * @version: 
 */
@Slf4j
public class RedisUtil {

	/** 连接池 */
	private JedisPool pool = null;
	
	/** redis成功标识 */
	public static String SUCCESS_IDENTIFY = "ok";
	
	
	/**
	 * 
	 * @Description:初始化构造连接池
	 * @author: 
	 * @date: 
	 * @version: 
	 */
	private RedisUtil() {
		getPool();
	}
	
	/**
	 * 构建连接池
	 */
	private JedisPool getPool() {
		if (pool == null) {
			/** Redis连接池配置类 */
			JedisPoolConfig config = new JedisPoolConfig();
			/** -1表示不限制 */
			config.setMaxTotal(-1);
			/** 一个pool最多有多少个状态为idle(空闲的)的实例 */
			config.setMaxIdle(5);
			/** 当borrow(引入)jedis连接时，超时时间，如果超时，抛出JedisConnectionException */
			config.setMaxWaitMillis(1000 * 10);
			/** 在borrow一个redis实例时，是否提前验证，如果为true，保证获取到的redis实例都是可用的 */
			config.setTestOnBorrow(true);
			pool = new JedisPool(config,CommonParam.REDIS_HOST, CommonParam.REDIS_PORT);
		}
		return pool;
	}


	/**
	 * 单例-静态内部类
	 */
	private static class Singleton {
		private static final RedisUtil redisUtil = new RedisUtil();
	}

	/**
	 * 获取实例
	 */
	public static RedisUtil getInstance() {
		return RedisUtil.Singleton.redisUtil;
	}

	/**
	 * 关闭连接 考虑到使用java7的try-with-resources必须要用close()方法。改名
	 */
	public void close(Jedis jedis) {
		if (jedis != null) {
			try {
				jedis.close();
			} catch (Exception e) {
				log.error("【redis】关闭连接异常");
				throw e;
			}
		}
	}

	/**
	 * 获取连接-同步
	 */
	private Jedis getJedis() {
		Jedis jedis = null;
		try {
			synchronized (this) {
				jedis = getPool().getResource();
			}
		} catch (Exception e) {
			log.error("【redis】获取连接异常");
			throw e;
		}
		return jedis;
	}

	/**
	 * 累加/创建一个计数器
	 */
	public void addKey(String key) {
		try (Jedis jedis = getJedis()) {
			jedis.incr(key);
		} catch (Exception e) {
			log.error("【redis】操作异常");
			throw e;
		}
	}

	/**
	 * 累加/创建一个计数器,并设置超时时间
	 */
	public void addKey(String key, int seconds) {
		try (Jedis jedis = getJedis()) {
			jedis.incr(key);
			jedis.expire(key, seconds);
		} catch (Exception e) {
			log.error("【redis】操作异常");
			throw e;
		}
	}

	/**
	 * 递减一个计数器
	 */
	public void subtractKey(String key) {
		try (Jedis jedis = getJedis()) {
			jedis.decr(key);
		} catch (Exception e) {
			log.error("【redis】操作异常,key={}", key);
			throw e;
		}
	}

	/**
	 * 给一个key设置超时时间
	 */
	public void setExpireTime(String key, int seconds) {
		try (Jedis jedis = getJedis()) {
			jedis.expire(key, seconds);
		} catch (Exception e) {
			log.error("【redis】操作异常,key={}", key);
			throw e;
		}
	}

	/**
	 * 使用指定key存储一个字符串值,制定失效时间,秒
	 */
	public void setKey(String key, String value, int seconds) {
		try (Jedis jedis = getJedis()) {
			/** 如果失败则抛出异常 */
			if (!jedis.setex(key, seconds, value).equalsIgnoreCase(SUCCESS_IDENTIFY)) {
				log.error("【redis】操作异常,key={},value={}", key, value);
				throw new ORGException(ErrorEnum.DATA_OPERTION_ERROR);
			}

		}
	}

	/**
	 * 使用指定key存储一个字符串值,不指定失效时间
	 */
	public void setKey(String key, String value) {
		try (Jedis jedis = getJedis()) {
			/** 如果失败则抛出异常 */
			if (!jedis.set(key,value).equalsIgnoreCase(SUCCESS_IDENTIFY)) {
				log.error("【redis】操作异常,key={},value={}", key, value);
				throw new ORGException(ErrorEnum.DATA_OPERTION_ERROR);
			}
		}
	}


	/**
	 * 获取指定key的value
	 */
	public String getValue(String key) {
		try (Jedis jedis = getJedis()) {
			return jedis.get(key);
		} catch (Exception e) {
			log.error("【redis】操作异常,key={}", key);
			throw e;
		}
	}

	/**
	 * 判断指定key是否存在
	 */
	public boolean isExist(String key) {
		try (Jedis jedis = getJedis()) {
			return jedis.exists(key);
		} catch (Exception e) {
			log.error("【redis】操作异常,key={}", key);
			throw e;
		}
	}

	/**
	 * 删除指定key
	 */
	public void deleteKey(String key) {
		try (Jedis jedis = getJedis()) {
			jedis.del(key);
		} catch (Exception e) {
			log.error("【redis】操作异常,key={}", key);
			throw e;
		}
	}

	public static void main(String[] args) {
		/*RedisUtil redisUtil = RedisUtil.getInstance();
		redisUtil.setKey("test1", "1111", 10);
		System.out.println(redisUtil.getValue("test1"));*/
		ResponseBasic redisResponse2 = RedisLock.acquisitionLock(103L);
			System.out.println(org.json.JSONObject.valueToString(redisResponse2));
	}

}