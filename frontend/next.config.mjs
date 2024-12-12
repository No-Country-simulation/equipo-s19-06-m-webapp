import webpack from "webpack";
import { createProxyMiddleware } from "http-proxy-middleware";

/** @type {import('next').NextConfig} */
const nextConfig = {
  images: {
    domains: ["cdn-images.dzcdn.net", "api.deezer.com"],
  },
  async rewrites() {
    return [
      {
        source: "/api/:path*",
        destination: "http://144.33.15.219:8080/:path*",
      },
    ];
  },
  async redirects() {
    return [
      {
        source: "/tracks",
        destination: "/api/tracks",
        permanent: true,
      },
    ];
  },
  webpack: (config, { dev }) => {
    if (dev) {
      config.devServer = {
        ...config.devServer,
        setup: (app) => {
          app.use(
            "/api",
            createProxyMiddleware({
              target: "http://144.33.15.219:8080",
              changeOrigin: true,
              pathRewrite: {
                "^/api": "",
              },
            })
          );
        },
      };
    }

    config.plugins.push(
      new webpack.IgnorePlugin({
        resourceRegExp:
          /@next\/next\/no-img-element|@typescript-eslint\/no-explicit-any|@typescript-eslint\/no-unused-vars|react-hooks\/exhaustive-deps/,
      })
    );

    return config;
  },
};

export default nextConfig;
