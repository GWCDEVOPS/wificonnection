// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "WifiConnection",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "WifiConnection",
            targets: ["WifiConnectionManagerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "WifiConnectionManagerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/WifiConnectionManagerPlugin"),
        .testTarget(
            name: "WifiConnectionManagerPluginTests",
            dependencies: ["WifiConnectionManagerPlugin"],
            path: "ios/Tests/WifiConnectionManagerPluginTests")
    ]
)